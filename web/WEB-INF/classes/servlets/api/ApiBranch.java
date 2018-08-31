package servlets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import itacademy.dto.BranchDto;
import itacademy.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/api/branch")
public class ApiBranch extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    BranchDto branchDto = new BranchDto("Солигорск", "ул. Богомолова 14");
    File file = new File("branch.json");
    file.createNewFile();
    objectMapper.writeValue(file, branchDto);
    String branchAsString = objectMapper.writeValueAsString(branchDto);
    System.out.println(branchAsString);
    showPage(req, resp);
  }

  private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
  }
}
