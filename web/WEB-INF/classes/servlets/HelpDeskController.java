package servlets;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.dao.impl.ProblemDaoImpl;
import itacademy.dto.models.TaskDto;
import itacademy.domain.services.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helpDesk")
public class HelpDeskController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("tasks", TaskServiceImpl.getInstance().findAllSelf((Long) req.getSession().getAttribute("userId")));
    showPage(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    TaskServiceImpl.getInstance().saveTask(getReqForCreateTaskDto(req));
    resp.sendRedirect("/helpDesk");
  }

  private TaskDto getReqForCreateTaskDto(HttpServletRequest request) {
    return new TaskDto(TaskDto.builder()
            .name(request.getParameter("nameTask"))
            .listenerId(1L)
//            .listenerId(Long.valueOf(request.getParameter("listenerId")))
            .text(request.getParameter("textTask"))
            .systemUserId(23L)
//            .systemUserId(Long.valueOf(request.getParameter("userId")))
            .statusId(1L)
//            .statusId(Long.valueOf(request.getParameter("statusId")))
            .build());
  }

  private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/helpDesk.jsp").forward(req, resp);
  }
}
