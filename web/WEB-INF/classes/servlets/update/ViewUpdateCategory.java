package servlets.update;

import itacademy.domain.dao.impl.CategoryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewCategory/Update")
public class ViewUpdateCategory extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CategoryDaoImpl dao = CategoryDaoImpl.getInstance();
        req.setAttribute("cat", dao.findById(Long.valueOf(id)).get());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/updateCategory.jsp").forward(req, resp);
    }
}