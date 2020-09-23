package db;
import java.sql.*;
import car.*;
import java.util.*;
public class AskDB extends DbConn {
	public int addAsk(Ask a)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("insert into ask values(?,?,?,?,?,?)");
				pst.setString(1, a.getNo());
				pst.setString(2, a.getClassno());
				pst.setInt(3, a.getYear());
				pst.setInt(4, a.getMonth());
				pst.setInt(5, a.getDay());
				pst.setString(6, a.getMessage());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public ArrayList<Ask> selectcask(String classno)
	{
		ArrayList<Ask> asks=new ArrayList<Ask>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select* from ask where ClassNo=?");
				pst.setString(1, classno);
				pst.executeQuery();
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Ask a=new Ask();
					a.setNo(rs.getString("No"));
					a.setClassno(rs.getString("ClassNo"));
					a.setYear(rs.getInt("Year"));
					a.setMonth(rs.getInt("Month"));
					a.setDay(rs.getInt("Day"));
					a.setMessage(rs.getString("Message"));
					asks.add(a);
				}
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return asks;
	}
	public ArrayList<Ask> selectpask(String no)
	{
		ArrayList<Ask> asks=new ArrayList<Ask>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select* from ask where No=?");
				pst.setString(1, no);
				pst.executeQuery();
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					Ask a=new Ask();
					a.setNo(rs.getString("No"));
					a.setClassno(rs.getString("ClassNo"));
					a.setYear(rs.getInt("Year"));
					a.setMonth(rs.getInt("Month"));
					a.setDay(rs.getInt("Day"));
					a.setMessage(rs.getString("Message"));
					asks.add(a);
				}
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return asks;
	}
	public int update(Ask a)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update ask set Message=? where No=? and ClassNo=? and Year=? and Month=? and Day=?");
				pst.setString(2, a.getNo());
				pst.setString(3, a.getClassno());
				pst.setInt(4, a.getYear());
				pst.setInt(5, a.getMonth());
				pst.setInt(6, a.getDay());
				pst.setString(1, a.getMessage());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int delete(Ask a)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("delete ask where No=? and ClassNo=? and Year=? and Month=? and Day=? and Message=?");
				pst.setString(1, a.getNo());
				pst.setString(2, a.getClassno());
				pst.setInt(3, a.getYear());
				pst.setInt(4, a.getMonth());
				pst.setInt(5, a.getDay());
				pst.setString(6, a.getMessage());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

}
