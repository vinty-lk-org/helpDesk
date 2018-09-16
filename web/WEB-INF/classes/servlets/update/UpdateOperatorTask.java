package servlets.update;

import itacademy.domain.dao.impl.TaskOperatorDaoImpl;
import itacademy.dto.models.TaskOperatorDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/operatorTask/Update")
public class UpdateOperatorTask extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long executorNameId = Long.valueOf(req.getParameter("executorNameId"));
        Long taskId = Long.valueOf(req.getParameter("taskId"));
        TaskOperatorDto task = new TaskOperatorDto();
        task.setTaskId(taskId);
        task.setExecutorId(executorNameId);
        TaskOperatorDaoImpl.getInstance().updateExecutor(task);
        resp.sendRedirect("/operatorChangeStatus");
    }
}