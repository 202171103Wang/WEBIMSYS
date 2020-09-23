package control;
import db.*;
import car.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addask
 */
@WebServlet("/addask")
public class addask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("no");
		UserDB userdb=new UserDB();
		person p=userdb.selectp(no);
		String classno=p.getClassno();
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		String message="‘›Œﬁ…Û∫À";
		Ask a=new Ask();
		a.setNo(no);
		a.setClassno(classno);
		a.setYear(year);
		a.setMonth(month);
		a.setDay(day);
		a.setMessage(message);
		AskDB askdb=new AskDB();
		int result=askdb.addAsk(a);
		askdb.close();
		userdb.close();
		if(result!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('…Í«Î≥…π¶');history.go(-1);</script>");
	    }
	    else
	    {
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('…Í«Î ß∞‹');history.go(-1);</script>");
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
