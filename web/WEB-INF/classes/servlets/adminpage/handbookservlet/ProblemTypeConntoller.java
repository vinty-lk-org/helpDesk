package servlets.adminpage.handbookservlet;

import itacademy.domain.dao.impl.ProblemDaoImpl;
import itacademy.domain.entity.Problem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/problemTypeSave")
public class ProblemTypeConntoller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProblemDaoImpl.getInstance().saveDao(new Problem (req.getParameter("problemName")));
        resp.sendRedirect("/adminFillPage");
    }
}