package servlets.api;

import com.fasterxml.jackson.core.JsonProcessingException;
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
//    resp.setCharacterEncoding("UTF-8");
    BranchDto branchDto = null;
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("branch.json");
    file.createNewFile();
    Optional<Branch> optionalBranch = BranchDaoImpl.getInstance().findById(3L);
    branchDto = BranchServiceImpl.getInstance().mapperBranch(optionalBranch.get());
    if (optionalBranch.isPresent()) {
      objectMapper.writeValue(file, branchDto);
    }
    String json = getJSON(branchDto);
    ServletOutputStream out = resp.getOutputStream();
    out.write(json.getBytes(StandardCharsets.UTF_8));
    out.flush();
    out.close();
  }

  public String getJSON(Object object) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
