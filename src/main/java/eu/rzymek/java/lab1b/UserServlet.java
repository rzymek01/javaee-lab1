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
    if (null != session) {
      // sesja istnieje, więc wylogowanie usera
      session.invalidate();
      response.sendRedirect("index.jsp?msg=Wylogowano");

      return;
    }

    // sesja nie istnieje, więc próba zalogowania
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
      // sprawdzenie loginu i hasła
      if (password.equals("abcd")) {
        valid = true;
      }
    }

    if (valid) {
      // utworzenie sesji
      session = request.getSession(true);
      session.setAttribute("login", login);

      // zarejestrowanie usera
      //@todo: pobranie Beana trzymającego listę userów i dodanie loginu

      // przekierowanie na listę userów
      response.sendRedirect("userlist.jsp");
    } else {
      // przekierowanie z wiadomością
      response.sendRedirect("index.jsp?msg=Nieprawidłowy%20login%20lub%20hasło");
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



