package servlets;

import itacademy.services.SystemUserServiceImpl;

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

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    super.doPost(req, resp);
  }

  private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("users", SystemUserServiceImpl.getInstance().getAllSystemUsersDto());
    req.setAttribute("myName", "Ярослав Зыскунов клевый парень.");
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
  }
}
