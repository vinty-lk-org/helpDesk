package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"executorPrimaryPage"})
public class ExecutorFilter implements Filter {

        private static final int ADMIN = 1;
        private static final int USER = 2;
        private static final int OPERATOR = 3;
        private static final int EXECUTOR = 4;

        //TODO: реализовать защиту страниц НЕ ПОЛЬЗОВАТЕЛЯ
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            Long userIdSession = (Long) ((HttpServletRequest) servletRequest).getSession().getAttribute("privilege");
            if (userIdSession == EXECUTOR) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
            }
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void destroy() {
        }
    }