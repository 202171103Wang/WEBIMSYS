package db;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import car.*;
public class RecordDB extends DbConn {
	public int addrecord(Record record)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("insert into record values(?,?,?,?,?,?)");
				pst.setString(1,record.getRoomNo());
				pst.setInt(2, record.getYear());
				pst.setInt(3, record.getMonth());
				pst.setInt(4, record.getDay());
				pst.setString(5,record.getGread());
				pst.setString(6, record.getMessage());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int update(Record record)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update record set Gread=?,Message=? where RoomNo=? and Year=? and Month=? and Day=? ");
				pst.setString(1,record.getGread());
				pst.setString(2, record.getMessage());
				pst.setString(3,record.getRoomNo());
				pst.setInt(4, record.getYear());
				pst.setInt(5, record.getMonth());
				pst.setInt(6, record.getDay());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public ArrayList <Record>selectrecord(){
		ArrayList<Record>records=new ArrayList<Record>();
		if(conn!=null)
		{
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from record");
				while(rs.next()) {
					Record r=new Record();
					r.setRoomNo(rs.getString("RoomNo"));
					r.setYear(rs.getInt("Year"));
					r.setMonth(rs.getInt("Month"));
					r.setDay(rs.getInt("Day"));
					r.setGread(rs.getString("Gread"));
					r.setMessage(rs.getString("Message"));
					records.add(r);
				}
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return records;
	}
	//查询班级卫生
	public ArrayList <Record>select_crecord(String classno){
		ArrayList<Record>records=new ArrayList<Record>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from view_class_record where ClassNo=?");
				pst.setString(1, classno);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					Record r=new Record();
					r.setRoomNo(rs.getString("RoomNo"));
					r.setYear(rs.getInt("Year"));
					r.setMonth(rs.getInt("Month"));
					r.setDay(rs.getInt("Day"));
					r.setGread(rs.getString("Gread"));
					r.setMessage(rs.getString("Message"));
					records.add(r);
				}
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return records;
	}
	//查询个人卫生
	public ArrayList <Record>select_precord(String no){
		ArrayList<Record>records=new ArrayList<Record>();
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("select * from view_record where No=?");
				pst.setString(1, no);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					Record r=new Record();
					r.setRoomNo(rs.getString("RoomNo"));
					r.setYear(rs.getInt("Year"));
					r.setMonth(rs.getInt("Month"));
					r.setDay(rs.getInt("Day"));
					r.setGread(rs.getString("Gread"));
					r.setMessage(rs.getString("Message"));
					records.add(r);
				}
				rs.close();
			}catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return records;
	}

}
