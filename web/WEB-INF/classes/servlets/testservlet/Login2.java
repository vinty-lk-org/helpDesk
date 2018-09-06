package servlets.testservlet;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login2")
public class Login2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameUser = req.getParameter("nameUser");
        String password = req.getParameter("password");
        System.out.println(nameUser);
        System.out.println(password);
        req.getSession().setAttribute("isUserLogin", true);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/helpDeskPage.jsp").forward(req, resp);
    }
}
