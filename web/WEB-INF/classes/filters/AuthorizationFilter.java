//package filters;
//
//import by.itacademy.entity.Role;
//import by.itacademy.entity.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
//@WebFilter(servletNames = {"HeroList"})
//public class AuthorizationFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if (isUserAdmin(servletRequest)) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            ((HttpServletResponse) servletResponse).sendRedirect("/login");
//        }
//    }
//
//    public boolean isUserAdmin(ServletRequest servletRequest) {
//        User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
//        return Objects.nonNull(user) && user.getRole() == Role.ADMIN;
//    }
//}
