package servlets;

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
    req.setAttribute("tasks", TaskServiceImpl.getInstance().findAllSelf(23L));
    showPage(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    TaskServiceImpl.getInstance().save(getReqForCreateTaskDto(req));
    resp.sendRedirect("/helpDesk");
  }

  private TaskDto getReqForCreateTaskDto(HttpServletRequest request) {
    return new TaskDto(TaskDto.builder()
            .name(request.getParameter("nameTask"))
            .text(request.getParameter("textUser"))
            .build());
  }

  private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/helpDesk.jsp").forward(req, resp);
  }
}