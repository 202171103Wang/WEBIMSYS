package db;
import java.util.*;
import java.sql.*;
import car.*;
public class UserDB extends DbConn{
	//判断是否可以登录
	public boolean isLogin(String userName,String userPwd,String professor)
	{
		boolean flag=false;
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from person where No = ? and Pwd=? and professor=?");
				pst.setString(1, userName);
				pst.setString(2, userPwd);
				pst.setString(3, professor);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					flag=true;
				}
				rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return flag;
	}
	//增加人员信息
	public int addperson(person person)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("insert into person values(?,?,?,?,?,?,?,?,?)");
				pst.setString(1,person.getNo());
				pst.setString(2, person.getName());
				pst.setString(3, person.getSex());
				pst.setString(4,person.getBirthday());
				pst.setString(5, person.getPwd());
				pst.setString(6,person.getClassno());
				pst.setString(7,person.getRoomno());
				pst.setString(8,person.getProfessor());
				pst.setString(9, person.getCall());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//查询个人信息
	public person2 select(String no)
	{
		person2 p=new person2();
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from view_person where No = ?");
				pst.setString(1, no);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					p.setNo(rs.getString("No"));
					p.setName(rs.getString("Name"));
					p.setBirthday(rs.getString("Birthday"));
					p.setClassname(rs.getString("classname"));
					p.setSex(rs.getString("Sex"));
					p.setPwd(rs.getString("Pwd"));
					p.setCall(rs.getString("call"));
					p.setRoomno(rs.getString("RoomName"));
					p.setProfessor(rs.getString("professor"));
				}
				rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return p;
	}
	public person selectp(String no)
	{
		person p=new person();
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from person where No = ?");
				pst.setString(1, no);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					p.setNo(rs.getString("No"));
					p.setName(rs.getString("Name"));
					p.setBirthday(rs.getString("Birthday"));
					p.setClassno(rs.getString("classno"));
					p.setSex(rs.getString("Sex"));
					p.setPwd(rs.getString("Pwd"));
					p.setCall(rs.getString("call"));
					p.setRoomno(rs.getString("RoomNo"));
					p.setProfessor(rs.getString("professor"));
				}
				rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return p;
	}
	//更新个人信息
	public int update(String no,String pwd,String call)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update person set Pwd=?,call=? where No=?");
				pst.setString(1, pwd);
				pst.setString(2,call);
				pst.setString(3, no);
				result=pst.executeUpdate();
			   }
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int updatestu(String no)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update person set professor='student' where No=?");
				pst.setString(1, no);
				result=pst.executeUpdate();
			   }
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int updateprof(String no)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update person set professor='admin' where No=?");
				pst.setString(1, no);
				result=pst.executeUpdate();
			   }
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//查询全部个人信息
	public ArrayList<person> selectperson()
	{
		ArrayList<person> persons=new ArrayList<person>();
		if(conn!=null)
		{
			try
			{
				PreparedStatement pst=conn.prepareStatement("select * from person");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					person p=new person();
					p.setNo(rs.getString("No"));
					p.setName(rs.getString("Name"));
					p.setBirthday(rs.getString("Birthday"));
					p.setClassno(rs.getString("classno"));
					p.setSex(rs.getString("Sex"));
					p.setPwd(rs.getString("Pwd"));
					p.setCall(rs.getString("call"));
					p.setRoomno(rs.getString("RoomNo"));
					p.setProfessor(rs.getString("professor"));
					persons.add(p);
				}
				rs.close();
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return persons;
	}
	//更新个人全部信息
	public int update(person person)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update person set Name=?,Sex=?,Birthday=?,Pwd=?,ClassNo=?,RoomNo=?,Professor=?,call=? where No=?");
				pst.setString(9,person.getNo());
				pst.setString(1, person.getName());
				pst.setString(2, person.getSex());
				pst.setString(3,person.getBirthday());
				pst.setString(4, person.getPwd());
				pst.setString(5,person.getClassno());
				pst.setString(6,person.getRoomno());
				pst.setString(7,person.getProfessor());
				pst.setString(8, person.getCall());
				result=pst.executeUpdate();
			   }
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
    //删除个人信息
	public int deleteperson(person person)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("delete  from person where No=?");
				pst.setString(1, person.getNo());
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
