package servlets.save;

import itacademy.domain.dao.impl.TaskOperatorDaoImpl;
import itacademy.dto.models.TaskOperatorShortDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/saveReport")
public class ReportController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskOperatorDaoImpl listFiles = TaskOperatorDaoImpl.getInstance();
        List<TaskOperatorShortDto> dtos = listFiles.findAllShortOperator(294L);
        resp.setHeader("Content-Disposition", "attachment; filename=\"report_" + dateTime() + ".html\"");
        resp.getWriter().write(htmlHead());
        resp.getWriter().write("<body>");

        resp.getWriter().write("<table border=\"1\">");
        resp.getWriter().write("<caption><h3>" + "Пользователи системы" + "</h3></caption>");
        resp.getWriter().write("<tr>");
        resp.getWriter().write("<th>Фамилия</th>");
        resp.getWriter().write("<th>Имя</th>");
        resp.getWriter().write("<th>Отчество</th>");
        resp.getWriter().write("<th>Почта</th>");
        resp.getWriter().write("<th>Пароль</th>");
        resp.getWriter().write("<th>Id Привилегий</th>");
        resp.getWriter().write("</tr>");
        dtos.forEach(e -> {
            try {
                resp.getWriter().write("<tr>");
                resp.getWriter().write("<td>" + e.getUserFamily() + "Фамилия" + "</th>");
                resp.getWriter().write("<td>" + e.getUserName() + "Имя" + "</th>");
                resp.getWriter().write("<td>" + e.getUserFamily() + "family" + "</th>");
                resp.getWriter().write("<td>" + e.getUserFamily() + "family" + "</th>");
                resp.getWriter().write("<td>" + e.getUserFamily() + "family" + "</th>");
                resp.getWriter().write("<td>" + e.getUserFamily() + "family" + "</th>");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    public String htmlHead() {
        String head;
        return head = "<!DOCTYPE html>\n" +
                "<HTML>\n" +
                "<HEAD>\n" +
                "<META charset=\"utf-8\">\n" +
                "<TITLE>Отчет</TITLE></h3>" +
                "</HEAD>";
    }

    public String dateTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        String formatedTime = localTime.format(DateTimeFormatter.ofPattern("hh-mm-ss"));
        return String.valueOf(localDate + "_" + formatedTime);
    }

}
