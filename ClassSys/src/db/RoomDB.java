package db;
import java.util.*;

import car.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class RoomDB extends DbConn
{
	//���ص�ǰ����ž�ס������
	public int selectnum(String roomno)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				  PreparedStatement pst=conn.prepareStatement("select p_num from dorm where RoomNo=?");
				  pst.setString(1,roomno);
				  ResultSet rs=pst.executeQuery();
				  while(rs.next())
				  {
					  result=rs.getInt("p_num");
				  }
			    }catch(SQLException e)
			{
			    	System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//����Ŀǰ��������(����)
	public int update(String roomno)
	{
		int result=0;
		int org_num=this.selectnum(roomno)+1;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update dorm set p_num=? where RoomNo=?");
				pst.setInt(1, org_num);
				pst.setString(2, roomno);
				result=pst.executeUpdate();
			   }
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//����Ŀǰ��������(����)
	public int update2(String roomno)
	{
		int result=0;
		int org_num=this.selectnum(roomno)-1;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("update dorm set p_num=? where RoomNo=?");
				pst.setInt(1, org_num);
				pst.setString(2, roomno);
				result=pst.executeUpdate();
			   }
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//Ѱ�Ҷ�Ӧ�༶�������
	public ArrayList<String> selectnos(String classname)
	{
		ArrayList<String> a=new ArrayList<String>();
		if(conn!=null)
		{
	    	try
	    	{
	 	    	PreparedStatement pst=conn.prepareStatement("select RoomNo from view_dorm_class where ClassName=?");
	 	    	pst.setString(1, classname);
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{
			    	String no=rs.getString("RoomNo");
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
	//�������᷿����Ϣ��Ϊ��ͬ����ѡȡ��ͬ�༶
	public int addRoom(Room room) {
    	int result=0;
    	if(conn!=null) {
    		try {
    			PreparedStatement pst=conn.prepareStatement("insert into dorm values(?,?,'0')");
				pst.setString(1, room.getRoomNo());
				pst.setString(2,room.getClassNo());
				result=pst.executeUpdate();
    		}
    		catch(SQLException e)
    		{
    		    
    			System.out.println(e.getMessage());
    		}
    	}
    	return result;
    }
	//��ѯȫ��������Ϣ
	public ArrayList<Room> selectroom()
	{
		ArrayList<Room>rooms=new ArrayList<Room>();
		if(conn!=null)
		{
	    	try
	    	{
	 	    	PreparedStatement pst=conn.prepareStatement("select * from dorm");
		    	ResultSet rs=pst.executeQuery();
		    	while(rs.next())
		    	{
			    	Room r=new Room();
			    	r.setClassNo(rs.getString("ClassNo"));
			    	r.setRoomNo(rs.getString("RoomNo"));
			    	r.setNum(rs.getString("p_num"));
			    	rooms.add(r);
		     	}
		    	rs.close();
	    	}
	    	catch(SQLException e)
	    	{
		    	System.out.println(e.getMessage());
	    	}
    	}
		return rooms;
	}
	//�޸�������Ϣ
	public int updateroom(Room room)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("Update dorm set ClassNo=? , p_num=? where RoomNo=? ");
				pst.setString(1, room.getClassNo());
				pst.setString(2, room.getNum());
				pst.setString(3, room.getRoomNo());
				result=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	//ɾ��������Ϣ
	public int deleteroom(Room room)
	{
		int result=0;
		if(conn!=null)
		{
			try {
				PreparedStatement pst=conn.prepareStatement("delete dorm where RoomNo=? ");
				pst.setString(1, room.getRoomNo());
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
