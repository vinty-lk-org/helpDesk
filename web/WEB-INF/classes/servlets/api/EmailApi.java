package servlets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import itacademy.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/api/email")
public class EmailApi extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    req.getParameter("");
    ObjectMapper objectMapper = new ObjectMapper();
    boolean isEmail = SystemUserServiceImpl.getInstance().isEmail("email");
    File file = new File("email.json");
    file.createNewFile();
    objectMapper.writeValue(file, isEmail);
    String eMailAsString = objectMapper.writeValueAsString(isEmail);
    System.out.println(eMailAsString);
    ServletOutputStream out = resp.getOutputStream();
    out.write(eMailAsString.getBytes(StandardCharsets.UTF_8));
    out.flush();
    out.close();
  }
}
