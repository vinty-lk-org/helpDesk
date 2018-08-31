package servlets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.dto.BranchDto;
import itacademy.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/api/branch")
public class ApiBranch extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Branch branch = null;
    ObjectMapper objectMapper = new ObjectMapper();
    Optional<Branch> branchDto = BranchDaoImpl.getInstance().findById(3L);
    File file = new File("branch.json");
    file.createNewFile();
    if (branchDto.isPresent()) {
      branch = branchDto.get();
      System.out.println(branch);
      objectMapper.writeValue(file, branch);
    }
    String branchAsString = objectMapper.writeValueAsString(branch);
    System.out.println(branchAsString);
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    ServletOutputStream out = resp.getOutputStream();
    out.write(branchAsString.getBytes());
    out.flush();
    out.close();
  }
}
