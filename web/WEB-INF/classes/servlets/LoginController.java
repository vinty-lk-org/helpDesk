package servlets;

import itacademy.domain.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getSession().setAttribute("message", "messageEnter");
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userInputEmail = req.getParameter("inputEmail");
    String userInputPassword = req.getParameter("inputPassword");
    String userLang = req.getParameter("lang");
    req.getSession().setAttribute("localLang", userLang);

    req.getSession().setAttribute("isUserLogin", true);
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/helpDesk.jsp").forward(req, resp);
  }
}
