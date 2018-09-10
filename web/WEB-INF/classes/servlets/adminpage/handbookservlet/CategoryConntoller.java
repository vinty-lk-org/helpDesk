package servlets.adminpage.handbookservlet;

import itacademy.domain.dao.impl.CategoryDaoImpl;
import itacademy.domain.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categoryTypeSave")
public class CategoryConntoller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDaoImpl.getInstance().saveDao(new Category(req.getParameter("categoryName")));
        resp.sendRedirect("/adminFillPage");
    }
}