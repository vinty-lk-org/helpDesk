package servlets.handbookservlet;

import itacademy.domain.dao.impl.SubdivisionDaoImpl;
import itacademy.domain.entity.Subdivision;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/subdivisionSave")
public class SubdivisionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubdivisionDaoImpl.getInstance().save(getReqForCreateSubdivision(req));
        resp.sendRedirect("/adminFillPage");
    }

    private Subdivision getReqForCreateSubdivision(HttpServletRequest request) {
        return new Subdivision(request.getParameter("nameSubdivision"));
    }
}