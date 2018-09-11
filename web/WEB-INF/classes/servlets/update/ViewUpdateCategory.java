package servlets.update;

import itacademy.domain.dao.impl.CategoryDaoImpl;
import itacademy.domain.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/viewCategoryUpdate")
public class ViewUpdateCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Optional<Category> category = CategoryDaoImpl.getInstance().findById(Long.valueOf(id));
        req.setAttribute("category", category);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }
}