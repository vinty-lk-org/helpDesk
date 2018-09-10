package servlets.authentication;

import itacademy.dto.models.SystemUserDto;
import itacademy.domain.services.BranchServiceImpl;
import itacademy.domain.services.SubdivisionServiceImpl;
import itacademy.domain.services.SystemUserServiceImpl;

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

    private SystemUserDto getReqForCreateSystemUserDto(HttpServletRequest req) {
        SystemUserDto userDto = SystemUserDto.builder()
                .name(req.getParameter("nameUser"))
                .family(req.getParameter("family"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .branchId(Long.valueOf(req.getParameter("branch_id")))
                .subdivisionId(Long.valueOf(req.getParameter("subdivision_id")))
                .build();
        System.out.println(userDto);
        return new SystemUserDto(userDto);
    }
}
