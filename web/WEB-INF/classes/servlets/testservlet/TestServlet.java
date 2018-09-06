package servlets.testservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter writer = resp.getWriter();
//        writer.print("чумовая пятница");
//        System.out.println(req.getParameter("first"));
//        System.out.println(req.getParameter("second"));
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(req.getParameter(names.nextElement()));
        }
    }
}

