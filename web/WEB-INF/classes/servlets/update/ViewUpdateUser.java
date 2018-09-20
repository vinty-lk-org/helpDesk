package servlets.update;

import itacademy.domain.dao.impl.CategoryDaoImpl;
import itacademy.domain.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewUser/Update")
public class ViewUpdateUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SystemUserServiceImpl dao = SystemUserServiceImpl.getInstance();
        req.setAttribute("use", dao.getSystemUserById(Long.valueOf(id)));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp").forward(req, resp);
    }
}



