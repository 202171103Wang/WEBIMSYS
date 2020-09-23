package control;
import car.*;
import db.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * Servlet implementation class PersonaddServlet
 */
@WebServlet("/PersonaddServlet")
public class PersonaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaddServlet() {
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
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("Birthday");
		String pwd=request.getParameter("Pwd");
		String classname=request.getParameter("ClassName");
		String professor=request.getParameter("professor");
		String call=request.getParameter("call");
		ClassDB classdb=new ClassDB();
		String cno=classdb.lookclassno(classname);
		String RoomNo="0";
		RoomDB roomdb=new RoomDB();
		if(professor.equals("student"))
		{
		    ArrayList<String> rooms=roomdb.selectnos(classname);
		    for(int i=0;i<rooms.size();i++)
		   {
		       String room=rooms.get(i);
		       int p_num=roomdb.selectnum(room);
		       if(p_num<5)
		       {
		        	 RoomNo=room;
		        	 break;
		       }
		   }
		}
		person person=new person();
		person.setNo(no);
		person.setName(name);
		person.setSex(sex);
		person.setBirthday(birthday);
		person.setPwd(pwd);
		person.setClassno(cno);
		person.setProfessor(professor);
		person.setCall(call);
		person.setRoomno(RoomNo);
		UserDB userdb=new UserDB();
		int result=userdb.addperson(person);
		int x=roomdb.update(RoomNo);
		roomdb.close();
		userdb.close();
		if(result!=0&&x!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('插入成功');history.go(-1);</script>");
	    }
	    else
	    {
	    	System.out.println(person.getClassno());
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('插入失败');history.go(-1);</script>");
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
