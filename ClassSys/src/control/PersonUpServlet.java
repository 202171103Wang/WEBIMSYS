package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.person;
import db.ClassDB;
import db.RoomDB;
import db.UserDB;

/**
 * Servlet implementation class PersonUpServlet
 */
@WebServlet("/PersonUpServlet")
public class PersonUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("No");
		String pwd=request.getParameter("Pwd");
		String call=request.getParameter("call");
		UserDB userdb=new UserDB();
		int result=userdb.update(no,pwd,call);
		userdb.close();
		if(result!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('更新成功');history.go(-1);</script>");
	    }
	    else
	    {
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('更新失败');history.go(-1);</script>");
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
