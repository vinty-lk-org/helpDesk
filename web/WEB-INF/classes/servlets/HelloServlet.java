package servlets;

import itacademy.service.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  private static SystemUserServiceImpl systemUserService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    showPage(req, resp);
  }

  private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("users", SystemUserServiceImpl.getInstance().getAllSystemUsersDto());
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
  }
}
