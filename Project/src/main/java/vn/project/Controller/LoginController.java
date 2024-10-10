package vn.project.Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.project.Dao.IUserDao;
import vn.project.Dao.Impl.Userimpl;
import vn.project.Model.UserModel;
import vn.project.Services.IUserService;
import vn.project.Services.Impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/register", "/rp" })
public class LoginController extends HttpServlet {

	IUserService service = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("login")) {
			req.getRequestDispatcher("views/login.jsp").forward(req, resp);
		} else if (url.contains("register")) {
			req.getRequestDispatcher("views/register.jsp").forward(req, resp);
		}else if(url.contains("rp"))
		{
			req.getRequestDispatcher("views/rp.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("login")) {

			String username = req.getParameter("username");
			String password = req.getParameter("password");

			String alertMsg = " ";
			if (username.isEmpty() || password.isEmpty()) {
				alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("views/login.jsp").forward(req, resp);
				return;
			}
			//
			UserModel user = service.login(username, password);
			if (user != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				resp.sendRedirect(req.getContextPath() + "/waiting");
			} else {
				alertMsg = "Tài khoản hoặc mật khẩu không đúng";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("views/login.jsp").forward(req, resp);
			}
		} else if (url.contains("register")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");
			String rp = req.getParameter("rp");
			String alertMsg = "";

			if (!password.equals(rp)) {
				alertMsg = "Mật khẩu không giống nhau!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("views/register.jsp").forward(req, resp);
			}

			else {
				IUserDao Dao = new Userimpl();
				UserModel a = Dao.FindByUserName(username);
				if (a != null) {
					alertMsg = "Tài khoản đã tồn tại";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("views/register.jsp").forward(req, resp);
				}
				UserModel b = Dao.FindByEmail(email);
				if (b != null) {
					alertMsg = "Email đã tồn tại";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("views/register.jsp").forward(req, resp);
				}
				UserModel user = service.register(username, password, email, fullname);
				if (user == null) {
					req.setAttribute("alert", alertMsg);
					resp.sendRedirect(req.getContextPath() + "/login");
				} else {
					alertMsg = "System error!";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("views/register.jsp").forward(req, resp);
				}
			}
		}else if (url.contains("rp"))
		{
			String email = req.getParameter("email");
			String to = req.getParameter("to");
			String subject = req.getParameter("subject");
			String password = req.getParameter("password");
			IUserDao dao = new Userimpl();
			UserModel b = dao.FindByEmail(email);
			
			UserModel mail = dao.rp(email);
			String alertMsg ="";
			if(b==null) {
				alertMsg =
						"Email không tồn tại";
						req.setAttribute("alert", alertMsg);
						req.getRequestDispatcher("views/rp.jsp").forward(req, resp);
			}
			else {
				if(mail!= null) {
					alertMsg =
							"Mật khẩu cập nhật thất bại";
							req.setAttribute("alert", alertMsg);	
							req.getRequestDispatcher("views/rp.jsp").forward(req, resp);
				}
				else {
					to = email;
					service.send(to, subject, password);
					alertMsg =
						"Mật khẩu của bạn đã được cập nhật";
						req.setAttribute("alert", alertMsg);	
				req.getRequestDispatcher("views/login.jsp").forward(req, resp);
				}
			}
		}
	}
}

