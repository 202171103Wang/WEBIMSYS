package control;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.UserDB;
import javax.servlet.http.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("No");
		String password=request.getParameter("Pwd");
		String userVCode=request.getParameter("userVCode");
		String professor=request.getParameter("professor");
		HttpSession session=request.getSession();
		session.setAttribute("no",username);
		String validateCode=(String)session.getAttribute("validateCode");
		if(userVCode.equalsIgnoreCase(validateCode)) {
			UserDB userDB=new UserDB();
			if(userDB.isLogin(username, password,professor))
			{
				if(professor.equals("teacher"))
				{
				  response.sendRedirect("teacher.jsp");
				}
				if(professor.equals("student"))
				{
					response.sendRedirect("student.jsp");
				}
				if(professor.equals("admin"))
				{
					response.sendRedirect("admin.jsp");
				}
				if(professor.equals("control"))
				{
					response.sendRedirect("control.jsp");
				}
			}
			else {
				session.setAttribute("isLogin", "false");
				response.sendRedirect("error.jsp");
			}
			userDB.close();
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('—È÷§¬Î ‰»Î¥ÌŒÛ');history.go(-1);</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
