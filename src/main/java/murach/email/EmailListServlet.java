package murach.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.business.User;

public class EmailListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		String url = "/index.html";
		
		String action = req.getParameter("action");
		if(action == null) {
			action = "join";
		}
		
		if(action.equals("join")) {
			url = "/index.html";
		}
		else if (action.equals("add")) {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String email = req.getParameter("email");
			
			User user = new User(firstName, lastName, email);
			/* UserDB.insert(user); */
			
			req.setAttribute("user", user);
			url = "/thanks.jsp";
		}
		
		getServletContext()
			.getRequestDispatcher(url)
			.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
