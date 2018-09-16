package servlets.savereport;

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
        resp.getWriter().write("<caption><h2>" + "Все заявки оператора" + "</h2></caption>");
        resp.getWriter().write("<tr>");
        resp.getWriter().write("<th>_№ заявки_</th>");
        resp.getWriter().write("<th>__краткое содержание__</th>");
        resp.getWriter().write("<th>_____Имя_____</th>");
        resp.getWriter().write("<th>____фамилия___</th>");
        resp.getWriter().write("<th>____Подразделение____</th>");
        resp.getWriter().write("<th>_____Статус_____</th>");
        resp.getWriter().write("</tr>");
        dtos.forEach(e -> {
            try {
                resp.getWriter().write("<tr>");
                resp.getWriter().write("<td>" + e.getIdTask() + "</th>");
                resp.getWriter().write("<td>" + e.getTaskName() + "</th>");
                resp.getWriter().write("<td>" + e.getUserName() + "</th>");
                resp.getWriter().write("<td>" + e.getUserFamily() + "</th>");
                resp.getWriter().write("<td>" + e.getSubdivision() + "</th>");
                resp.getWriter().write("<td>" + e.getStatus() + "</th>");
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
