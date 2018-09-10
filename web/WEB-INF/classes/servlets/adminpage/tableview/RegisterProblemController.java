package servlets.adminpage.tableview;

import itacademy.domain.dao.impl.ProblemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerProblem")
public class RegisterProblemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("problems", ProblemDaoImpl.getInstance().findAll());
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/registerProblem.jsp").forward(req, resp);
    }
}