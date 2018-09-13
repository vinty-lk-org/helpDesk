//package filters;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class ResourcesFilter implements Filter {
//
//  @Override
//  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//    if (servletRequest instanceof HttpServletRequest) {
//      HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//      String path = httpServletRequest.getRequestURI();
//      System.out.println(path);
//
//      if (path.endsWith(".css")) {
//        filterChain.doFilter(servletRequest, servletResponse);
//        return;
//      }
//      if (path.endsWith(".js")) {
//        filterChain.doFilter(servletRequest, servletResponse);
//        return;
//
//      }
//      if (path.contains("resources")) {
//        filterChain.doFilter(servletRequest, servletResponse);
//        return;
//      }
//    }
//  }
//
//  @Override
//  public void init(FilterConfig filterConfig) throws ServletException {
//  }
//
//  @Override
//  public void destroy() {
//  }
//}