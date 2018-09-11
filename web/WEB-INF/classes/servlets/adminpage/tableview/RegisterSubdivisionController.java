package servlets.adminpage.tableview;

import itacademy.domain.dao.impl.BranchDaoImpl;
import itacademy.domain.services.SubdivisionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerSubdivision")
public class RegisterSubdivisionController extends HttpServlet {



    public class RegisterBranchController extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("subdivision", SubdivisionServiceImpl.getInstance().getAllSubdivisionDto());
            showPage(req, resp);
        }

        private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/registerSubdivision.jsp").forward(req, resp);
        }
    }
}
