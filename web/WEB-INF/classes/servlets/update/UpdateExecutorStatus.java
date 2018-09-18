package servlets.update;

import itacademy.domain.dao.impl.*;
import itacademy.dto.models.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/executorStatus/Update")
public class UpdateExecutorStatus extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long taskId = Long.valueOf(req.getParameter("taskId"));
        Long statusNameId = Long.valueOf(req.getParameter("statusNameId"));
        TaskExecutorDto task = new TaskExecutorDto(taskId, statusNameId);
        TaskExecutorDaoImpl.getInstance().updateStatus(task);
//        task.setTaskId(taskId);
//        task.setStatusId(statusNameId);
        resp.sendRedirect("/executorTaskView");
    }
}
