package servlets.userpage;

import itacademy.domain.dao.impl.ExecutorDaoImpl;
import itacademy.domain.dao.impl.PrivilegeDaoImpl;
import itacademy.domain.dao.impl.StatusDaoImpl;
import itacademy.domain.dao.impl.TaskOperatorDaoImpl;
import itacademy.domain.services.SystemUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userChangeStatus")
public class UserChangeStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SystemUserServiceImpl dao = SystemUserServiceImpl.getInstance();

        PrivilegeDaoImpl privilegeDao = PrivilegeDaoImpl.getInstance();


        req.setAttribute("userId", dao.getSystemUserById(Long.valueOf(id)).getId());

        req.setAttribute("privilege", privilegeDao.findAll());


        getServletContext().getRequestDispatcher("/WEB-INF/jsp/userStatus.jsp").forward(req, resp);
    }
}

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        SystemUserServiceImpl dao = SystemUserServiceImpl.getInstance();
//        req.setAttribute("use", dao.getSystemUserById(Long.valueOf(id)));
//        getServletContext().getRequestDispatcher("/WEB-INF/jsp/updateUser.jsp").forward(req, resp);
//    }
//}


//        req.setAttribute("operatorId", dao.findByIdOperatorTask(Long.valueOf(id)).get());
//                req.setAttribute("status", statusDao.findAllStatus());