package servlets.executor;

import itacademy.domain.dao.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/executorTaskView", name = "executorTaskView")
public class ExecutoraskViewController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("executorTaskView", TaskExecutorDaoImpl.getInstance().findAllShortExecutorStatus(293L));
            showPage(req, resp);
        }

        private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/executorTaskView.jsp").forward(req, resp);
        }
    }


