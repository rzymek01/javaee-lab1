package eu.rzymek.java.lab1b;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

  public static final String LOGIN_FIELD = "login";
  public static final String PASSWORD_FIELD = "passwd";

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException    if a servlet-specific error occurs
   * @throws java.io.IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    System.out.println("UserServlet: in processRequest");

    HttpSession session = request.getSession(false);
    if (null != session && null != session.getAttribute("login")) {
      // user is logged in, hence log out
      session.invalidate();
      response.sendRedirect("index.jsp?msg=Wylogowano");

      return;
    }

    // user is logged out, hence try to log in
    boolean valid = false;

    String[] loginText = request.getParameterMap().get(LOGIN_FIELD);
    String[] passwordText = request.getParameterMap().get(PASSWORD_FIELD);

    String login = null;
    if (loginText != null && loginText.length > 0) {
      login = loginText[0];
    }

    String password = null;
    if (passwordText != null && passwordText.length > 0) {
      password = passwordText[0];
    }

    if (login != null && password != null) {
      // check login and password
      if (password.equals("abcd")) {
        valid = true;
      }
    }

    if (valid) {
      // create a session (behind the scene the session listener add user to list)
      session = request.getSession(true);
      session.setAttribute("login", login);

      // redirect to user list
      response.sendRedirect("userlist.jsp");
    } else {
      // redirect with message
      response.sendRedirect("index.jsp?msg=Nieprawidlowy%20login%20lub%20haslo");
    }
  }

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Handles user login and logout";
  }
}



