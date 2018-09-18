package servlets.executor;

import itacademy.domain.dao.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/executorChangeStatus")
public class ExecutorChangeStatusController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            TaskExecutorDaoImpl dao = TaskExecutorDaoImpl.getInstance();
            StatusDaoImpl statusDao = StatusDaoImpl.getInstance();
//            ExecutorDaoImpl executorDao = ExecutorDaoImpl.getInstance();

            req.setAttribute("executorId", dao.findByIdExecutorTask(Long.valueOf(id)).get());
            req.setAttribute("status", statusDao.findAllStatus());
//            req.setAttribute("executor",executorDao.findAllExecutorDto());
           getServletContext().getRequestDispatcher("/WEB-INF/jsp/executorStatus.jsp").forward(req, resp);
        }
    }