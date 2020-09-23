package control;
import car.*;
import db.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pupdate
 */
@WebServlet("/pupdate")
public class pupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("No");
		String name=request.getParameter("Name");
		String sex=request.getParameter("Sex");
		String birthday=request.getParameter("Birthday");
		String pwd=request.getParameter("Pwd");
		String classno=request.getParameter("ClassNo");
		String roomno=request.getParameter("RoomNo");
		String professor=request.getParameter("professor");
		String call=request.getParameter("call");
		person person=new person();
		person.setNo(no);
		person.setName(name);
		person.setSex(sex);
		person.setBirthday(birthday);
		person.setPwd(pwd);
		person.setClassno(classno);
		person.setProfessor(professor);
		person.setCall(call);
		person.setRoomno(roomno);
		UserDB userdb=new UserDB();
		int result=userdb.update(person);
		userdb.close();
		if(result!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('修改成功');</script>");
	    }
	    else
	    {
	    	System.out.println(person.getClassno());
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('修改失败');history.go(-1);</script>");
	    }
		response.sendRedirect("person_mess.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
