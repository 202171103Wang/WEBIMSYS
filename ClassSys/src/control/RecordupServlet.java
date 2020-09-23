package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.Record;
import db.RecordDB;

/**
 * Servlet implementation class RecordupServlet
 */
@WebServlet("/RecordupServlet")
public class RecordupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String roomno=request.getParameter("RoomNo");
		String gread=request.getParameter("grade");
		String y=request.getParameter("Year");
		String m=request.getParameter("Month");
		String d=request.getParameter("Day");
		int year=0; 
		year=Integer.parseInt(y);
		int month=0; 
		month=Integer.parseInt(m);
		int day=0; 
		day=Integer.parseInt(d);
		String message=request.getParameter("message");
		Record record=new Record();
		record.setRoomNo(roomno);
		record.setYear(year);
		record.setMonth(month);
		record.setDay(day);
		record.setGread(gread);
		record.setMessage(message);
		RecordDB recordb=new RecordDB();
		int result=recordb.update(record);
		recordb.close();
		if(result!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('修改成功');history.go(-1);</script>");
	    }
	    else
	    {
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('修改失败');history.go(-1);</script>");
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
