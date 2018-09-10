package servlets.userpage;

import itacademy.domain.dao.impl.SystemUserDaoImpl;
import itacademy.domain.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserPageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("branches", BranchServiceImpl.getInstance().getAllBranchesDto());
        req.setAttribute("subdivisions", SubdivisionServiceImpl.getInstance().getAllSubdivisionDto());
        req.setAttribute("privileges", PrivilegeServiceImpl.getInstance().getAllPrivilege());
        req.setAttribute("user", SystemUserServiceImpl.getInstance().getSystemUserById(23L));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }
}