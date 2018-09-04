package servlets;

import itacademy.domain.dao.impl.ProblemDaoImpl;
import itacademy.dto.TaskDto;
import itacademy.services.SystemUserServiceImpl;

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
        req.setAttribute("problems", ProblemDaoImpl.getInstance().findAll());
        req.setAttribute("myName", "Выберите категорию");
        showPage(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SystemUserServiceImpl.getInstance().saveUser(getReqForCreateTaskDto(req));
//        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
//    }

    private TaskDto getReqForCreateTaskDto(HttpServletRequest request) {
        return new TaskDto(TaskDto.builder()
                        .name(request.getParameter("nameTask"))
                        .text(request.getParameter("textUser"))
                        .build()
        );
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }
}