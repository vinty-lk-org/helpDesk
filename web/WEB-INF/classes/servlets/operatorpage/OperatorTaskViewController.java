package servlets.operatorpage;

import itacademy.domain.dao.impl.TaskDaoImpl;
import itacademy.domain.dao.impl.TaskOperatorDaoImpl;
import itacademy.domain.dao.interfaces.TaskOperatorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/operatorTaskView")
public class OperatorTaskViewController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("operatorTaskView", TaskOperatorDaoImpl.getInstance().findAllShortOperator(294L));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/operatorTaskView.jsp").forward(req, resp);
    }
}