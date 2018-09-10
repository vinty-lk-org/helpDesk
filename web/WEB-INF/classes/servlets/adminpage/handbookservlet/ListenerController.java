package servlets.adminpage.handbookservlet;

import itacademy.domain.dao.impl.ListenerDaoImpl;
import itacademy.domain.entity.Listener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/listenerSave")
public class ListenerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListenerDaoImpl.getInstance().save(new Listener(req.getParameter("listenerName")));
        resp.sendRedirect("/adminFillPage");
    }
}
