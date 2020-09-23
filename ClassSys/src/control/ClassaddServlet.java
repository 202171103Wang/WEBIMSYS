package control;
import car.Clas;
import db.ClassDB;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClassaddServlet
 */
@WebServlet("/ClassaddServlet")
public class ClassaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassaddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Clas Class=new Clas();
		String no=request.getParameter("ClassNo");
		String name=request.getParameter("ClassName");
		Class.setClassNo(no);
		Class.setClassName(name);
		ClassDB classdb=new ClassDB();
		int x=classdb.addClass(Class);
		classdb.close();
	    if(x!=0)
	    {
	    	response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>alert('插入成功');history.go(-1);</script>");
	    }
	    else
	    {
	     response.setContentType("text/html;charset=utf-8");
		 PrintWriter out=response.getWriter();
		 out.print("<script>alert('插入失败');</script>");
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
