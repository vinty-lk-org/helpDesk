package servlets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.entity.Branch;
import itacademy.dto.BranchDto;
import itacademy.services.BranchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@WebServlet("/api/branch")
public class ApiBranch extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    BranchDto branchDto = null;
    ObjectMapper objectMapper = new ObjectMapper();
    Optional<Branch> optionalBranch = BranchDaoImpl.getInstance().findById(3L);
    File file = new File("branch.json");
    file.createNewFile();
    if (optionalBranch.isPresent()) {
      branchDto = BranchServiceImpl.getInstance().mapperBranch(optionalBranch.get());
      objectMapper.writeValue(file, branchDto);
    }
    String branchAsString = objectMapper.writeValueAsString(branchDto);
    System.out.println(branchAsString);
    ServletOutputStream out = resp.getOutputStream();
    out.write(branchAsString.getBytes(StandardCharsets.UTF_8));
    out.flush();
    out.close();
  }
}
