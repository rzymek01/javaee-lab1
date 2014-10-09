package eu.rzymek.java.lab1b;

import eu.rzymek.java.lab1b.entity.CurrencyConvertion;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

public class SessionListener implements HttpSessionListener, ServletContextListener, HttpSessionAttributeListener {

//  private static int totalActiveSessions;
//
//  public static int getTotalActiveSession() {
//    return totalActiveSessions;
//  }

  // ServletContextListener part
  @Override
  public void contextInitialized(ServletContextEvent e) {
    System.out.println("ServletContext initialized");
    e.getServletContext().setAttribute(UserList.NAME, new UserList());
  }

  @Override
  public void contextDestroyed(ServletContextEvent e) {
    System.out.println("ServletContext destroyed");
  }

  // HttpSessionListener part
  @Override
  public void sessionCreated(HttpSessionEvent e) {
//    totalActiveSessions++;
    System.out.println("sessionCreated - add one session into counter");

    // put a few currency converters into session
    ArrayList<CurrencyConvertion> list = new ArrayList<>();
    list.add(new CurrencyConvertion(10.f, "EUR", "PLN"));
    list.add(new CurrencyConvertion(2.f, "USD", "PLN"));
    list.add(new CurrencyConvertion(5.f, "GBP", "PLN"));
    list.add(new CurrencyConvertion(2.5f, "CHF", "PLN"));
    list.add(new CurrencyConvertion(100.f, "USD", "EUR"));
    list.add(new CurrencyConvertion(100.f, "EUR", "USD"));

    e.getSession().setAttribute("currConvList", list);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent e) {
//    totalActiveSessions--;
    System.out.println("sessionDestroyed - deduct one session from counter");

    // 1. get user login
    String login = (String) e.getSession().getAttribute("login");
    // 2. get Bean which is holding an user list
    UserList userList = (UserList) e.getSession().getServletContext().getAttribute(UserList.NAME);
    // 3. remove user from list by login
    userList.remove(login);
  }

  // HttpSessionAttributeListener part
  @Override
  public void attributeAdded(HttpSessionBindingEvent e) {
    System.out.println("Session attributeAdded");

    String name = e.getName();
    if (name.equals("login")) {
      String value = (String)e.getValue();
      UserList userList = (UserList) e.getSession().getServletContext().getAttribute(UserList.NAME);
      userList.add(value);
    }
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent e) {
    System.out.println("Session attributeRemoved");
    // nop
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent e) {
    System.out.println("Session attributeReplaced");
    // nop
  }
}