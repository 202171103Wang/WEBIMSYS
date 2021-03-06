package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.Ask;
import db.AskDB;
import db.UserDB;

/**
 * Servlet implementation class aupdate2
 */
@WebServlet("/aupdate2")
public class aupdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aupdate2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("no");
		String classno=request.getParameter("c");
		String y=request.getParameter("y");
		String m=request.getParameter("m");
		String d=request.getParameter("d");
		int year=Integer.parseInt(y);
		int month=Integer.parseInt(m);
		int day=Integer.parseInt(d);
		String message="已驳回";
		Ask a=new Ask();
		a.setNo(no);
		a.setClassno(classno);
		a.setYear(year);
		a.setMonth(month);
		a.setDay(day);
		a.setMessage(message);
		AskDB askdb=new AskDB();
		UserDB userdb=new UserDB();
		int x=userdb.updatestu(no);
		int result=askdb.update(a);
		userdb.close();
		askdb.close();
		if(result!=0&&x!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('驳回成功');history.go(-1);</script>");
	    }
	    else
	    {
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('驳回失败');history.go(-1);</script>");
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
