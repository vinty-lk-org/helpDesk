package servlets.update;

import itacademy.domain.dao.impl.CategoryDaoImpl;
import itacademy.domain.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/Update")
public class UpdateCategory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        CategoryDaoImpl.getInstance().update(new Category(categoryId, categoryName));
        resp.sendRedirect("/registerCategory");
    }
}