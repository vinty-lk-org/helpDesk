package servlets.tableview;

import itacademy.domain.dao.impl.TaskDaoImpl;
import itacademy.domain.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerTask")
public class RegisterTaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tasks", TaskDaoImpl.getInstance().findAll());
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/registerTask.jsp").forward(req, resp);
    }
}