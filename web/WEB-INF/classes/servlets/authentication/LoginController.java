package servlets.authentication;

import itacademy.domain.entity.SystemUser;
import itacademy.domain.entity.UserPrivilege;
import itacademy.domain.services.SystemUserServiceImpl;
import itacademy.domain.services.UserPrivilegeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("message", "messageEnter");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInputEmail = req.getParameter("inputEmail");
        String userInputPassword = req.getParameter("inputPassword");
        String userLang = req.getParameter("lang");
        req.getSession().setAttribute("localLang", userLang);

        Optional<SystemUser> userOptional = Optional.ofNullable(SystemUserServiceImpl.getInstance().findByEmail(userInputEmail));
        SystemUser user = null;
        if (userOptional.isPresent()) {
            if (userOptional.get().getId() != null) {
                user = userOptional.get();
                String eMail = user.getEmail();
                String nameUser = user.getName();
                String password = user.getPassword();
                List<UserPrivilege> userPrivilegeList = UserPrivilegeServiceImpl.getInstance().findAllUsersPrivilegesByUserId(user.getId());
                System.out.println(userPrivilegeList);
                Long privilege = userPrivilegeList.get(0).getPrivilegeId().getId();
                System.out.println(privilege);
                if ((eMail != null) && (password.equals(userInputPassword))) {
                    req.getSession().setAttribute("userId", user.getId());
                    req.getSession().setAttribute("userLoggedIn", true);
                    req.getSession().setAttribute("user", nameUser);
                    req.getSession().setAttribute("privilege", privilege);
                    System.out.println("Привилегия данного пользователя = " + privilege);
                    req.setAttribute("message", "Все ОК!");
                    String path = "";
                    switch (Math.toIntExact(privilege)) {
                        case 1:
                            path = "/admin";
                            break;
                        case 3:
                            path = "/operatorTaskView";
                            break;
                            // TODO: Вставить страницу на которую попадет исполнитель
//                        case 4:
//                            path = "/helpDesk";
//                            break;
                        default:
                            path = "/helpDesk";
                            break;
                    }
                    resp.sendRedirect(path);

                } else {
                    req.setAttribute("message", "errorPass");
                    doGet(req, resp);
                }

            } else resp.sendRedirect("/helpDesk");
        }
    }
}
