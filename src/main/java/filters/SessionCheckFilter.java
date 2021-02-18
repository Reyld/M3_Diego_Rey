package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entities.User;
import entities.AppConstants;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
@WebFilter(filterName = "SessionCheckFilter", urlPatterns = { "/user/*"})
public class SessionCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionCheckFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();



		User user = (User) session.getAttribute(AppConstants.SESSION_USER);

		if (user != null) {
			User.setInsession(true);
			chain.doFilter(request, response);
		} else {
			User.setInsession(false);
			request.getRequestDispatcher(AppConstants.LOGIN_PAGE).forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
