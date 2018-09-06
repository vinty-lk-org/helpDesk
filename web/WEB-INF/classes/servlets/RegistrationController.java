package servlets;

import itacademy.dto.SystemUserDto;
import itacademy.services.BranchServiceImpl;
import itacademy.services.SubdivisionServiceImpl;
import itacademy.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("branches", BranchServiceImpl.getInstance().getAllBranchesDto());
        req.setAttribute("subdivisions", SubdivisionServiceImpl.getInstance().getAllSubdivisionDto());
      getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SystemUserServiceImpl.getInstance().saveUser(getReqForCreateSystemUserDto(req));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    private SystemUserDto getReqForCreateSystemUserDto(HttpServletRequest request) {
        return new SystemUserDto(
                SystemUserDto.builder()
                        .name(request.getParameter("nameUser"))
                        .family(request.getParameter("family"))
                        .email(request.getParameter("email"))
                        .password(request.getParameter("password"))
                        .branchId(Long.valueOf(request.getParameter("branch_id")))
                        .subdivisionId(Long.valueOf(request.getParameter("subdivision_id")))
                        .build()
        );
    }
}
