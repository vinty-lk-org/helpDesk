//package filters;
//
//
//
//import itacademy.domain.entity.SystemUser;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
//@WebFilter("/*")
//public class AuthentificationFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if (isLoginPage(servletRequest) || isUserAuthorized(servletRequest)) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            ((HttpServletResponse) servletResponse).sendRedirect("/login");
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    private boolean isUserAuthorized(ServletRequest servletRequest) {
//        SystemUser user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
//        return Objects.nonNull(user);
//    }
//
//    public boolean isLoginPage(ServletRequest servletRequest) {
//        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
//        return MappingConst.LOGIN_PAGE.equals(requestURI);
//    }
//}
