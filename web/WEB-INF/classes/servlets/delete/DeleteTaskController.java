package servlets.delete;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.dao.impl.TaskDaoImpl;
import itacademy.domain.services.BranchServiceImpl;
import itacademy.domain.services.TaskServiceImpl;
import itacademy.domain.services.interfaces.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/Delete")
public class DeleteTaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TaskServiceImpl.getInstance().deleteTask(Long.valueOf(id));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/userDesk");
//        getServletContext().getRequestDispatcher("/WEB-INF/jsp/helpDesk.jsp").forward(req, resp);
    }
}
