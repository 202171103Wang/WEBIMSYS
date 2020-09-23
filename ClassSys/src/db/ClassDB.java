package db;
import java.sql.*;
import java.util.ArrayList;
import car.Clas;
public class ClassDB extends DbConn{
	public ArrayList<String> lookforClassname()
	{
		ArrayList<String> a=new ArrayList<String>();
	   if(conn!=null)
	    {
	    	try
	    	{
	 	    	PreparedStatement pst=conn.prepareStatement("select * from class");
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{
			    	String no=rs.getString("ClassName");
			    	a.add(no);
		     	}
		    	rs.close();
	    	}
	    	catch(SQLException e)
	    	{
		    	System.out.println(e.getMessage());
	    	}
    	}
	   return a;
	}
	public String lookclassno(String classname)
	{
		String a="";
		if(conn!=null)
	    {
	    	try
	    	{
	 	    	PreparedStatement pst=conn.prepareStatement("select * from class where ClassName=?");
	 	    	pst.setString(1, classname);
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{
			      a=rs.getString("ClassNo");
			    	
		     	}
		    	rs.close();
	    	}
	    	
	    	catch(SQLException e)
	    	{
		    	System.out.println(e.getMessage());
	    	}
    	}
	   return a;
	}
	//增加班级信息
	public int addClass(Clas Class) {
    	int result=0;
    	if(conn!=null) {
    		try {
    			PreparedStatement pst=conn.prepareStatement("insert into class values(?,?)");
				pst.setString(1, Class.getClassNo());
				pst.setString(2,Class.getClassName());
				result=pst.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return result;
    }
	//查询全部班级信息
	public ArrayList<Clas> selectclass()
	{
		ArrayList<Clas> classes=new ArrayList<Clas>();
		if(conn!=null)
	    {
	    	try
	    	{
	 	    	PreparedStatement pst=conn.prepareStatement("select * from class");
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{
			      Clas c=new Clas();
			      c.setClassNo(rs.getString("ClassNo"));
			      c.setClassName(rs.getString("ClassName"));
			      classes.add(c);	
		     	}
		    	rs.close();
	    	}
	    	catch(SQLException e)
	    	{
		    	System.out.println(e.getMessage());
	    	}
    	}
		return classes;
	}
	//修改班级信息
	public int updateclass(Clas c)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("Update class set ClassName=? where ClassNo=?");
				pst.setString(1, c.getClassName());
				pst.setString(2, c.getClassNo());
				result=pst.executeUpdate();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//删除班级信息
	public int deleteclass(Clas c)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("delete from class where ClassNo=?");
				pst.setString(1, c.getClassNo());
				result=pst.executeUpdate();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
