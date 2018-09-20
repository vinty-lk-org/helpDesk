package servlets.userpage;

import itacademy.domain.services.*;
import itacademy.dto.models.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/userHistoryDesk")
public class HelpDeskHistoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setAttribute("tasks", TaskServiceImpl.getInstance().findAllSelfStatus((Long) req.getSession().getAttribute("userId")));
      showPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      TaskServiceImpl.getInstance().saveTask(getReqForCreateTaskDto(req));
      resp.sendRedirect("/userHistoryDesk");
    }

    private TaskDto getReqForCreateTaskDto(HttpServletRequest request) {
      return new TaskDto(TaskDto.builder()
              .name(request.getParameter("nameTask"))
              .listenerId(1L)
//            .listenerId(Long.valueOf(request.getParameter("listenerId")))
              .text(request.getParameter("textTask"))
//            .systemUserId(23L)
              .systemUserId((Long)request.getSession().getAttribute("userId"))
//            .systemUserId(Long.valueOf(request.getParameter("userId")))
              .statusId(1L)
//            .statusId(Long.valueOf(request.getParameter("statusId")))
              .build());
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      getServletContext().getRequestDispatcher("/WEB-INF/jsp/userHistoryDesk.jsp").forward(req, resp);
    }
  }
