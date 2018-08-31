package filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class EncoderFilter implements Filter {

  private static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
    servletResponse.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
    servletResponse.setContentType("text/html; charset=UTF-8");
    servletResponse.setContentType("application/json; charset=UTF-8");
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
  }
}
