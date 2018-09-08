package servlets;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.domain.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloController extends HttpServlet {
  private static SystemUserServiceImpl systemUserService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("users", SystemUserServiceImpl.getInstance().getAllSystemUsersDto());
    req.setAttribute("myName", "Выберите персону");
    showPage(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nameBranch = req.getParameter("nameBranch");
    String addressBranch = req.getParameter("addressBranch");
    Branch branch = new Branch(nameBranch, addressBranch);
    Long id = BranchDaoImpl.getInstance().save(branch);
    System.out.println(id);
    showPage(req, resp);
  }

  private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
  }
}
