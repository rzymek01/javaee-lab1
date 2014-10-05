package eu.rzymek.java.lab1b;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

  private static int totalActiveSessions;

  public static int getTotalActiveSession() {
    return totalActiveSessions;
  }

  @Override
  public void sessionCreated(HttpSessionEvent arg0) {
    totalActiveSessions++;
    System.out.println("sessionCreated - add one session into counter");

    // tutaj nic się nie dzieje - user jest dodawany w UserServlet
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
    totalActiveSessions--;
    System.out.println("sessionDestroyed - deduct one session from counter");

    //@todo: usunięcie usera z listy
    // 1. pobranie Beana trzymającego listę
    // 2. usunięcie wskazanego loginu z listy
  }
}