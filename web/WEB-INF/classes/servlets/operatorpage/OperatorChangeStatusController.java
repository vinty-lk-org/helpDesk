package servlets.operatorpage;

import itacademy.domain.dao.impl.ExecutorDaoImpl;
import itacademy.domain.dao.impl.StatusDaoImpl;
import itacademy.domain.dao.impl.TaskOperatorDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/operatorChangeStatus")
public class OperatorChangeStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TaskOperatorDaoImpl dao = TaskOperatorDaoImpl.getInstance();
        StatusDaoImpl statusDao = StatusDaoImpl.getInstance();
        ExecutorDaoImpl executorDao = ExecutorDaoImpl.getInstance();

        req.setAttribute("operatorId", dao.findByIdOperatorTask(Long.valueOf(id)).get());
        req.setAttribute("status", statusDao.findAllStatus());
        req.setAttribute("executor",executorDao.findAllExecutorDto());



        getServletContext().getRequestDispatcher("/WEB-INF/jsp/operatorStatus.jsp").forward(req, resp);
    }
}
