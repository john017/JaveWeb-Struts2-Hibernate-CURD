package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class conn2 {
	private conn con=new conn();
	private PreparedStatement pstmt=null;
	private Connection conn=null;
	public conn2(){
		con.connect();
		conn=con.con;
	}
	public ResultSet Searchall(){
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement("Select * from [table]");
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public boolean add(String str){
		String sqlstr="insert into [table](string)values(?)";
		try {
			pstmt=conn.prepareStatement(sqlstr);
			pstmt.setString(1, str);
			pstmt.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean remove(int id){
		try{
			String sqlstr="delete from [table] where id=?";
			pstmt=conn.prepareStatement(sqlstr);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public boolean update(String str,int id){
		try{
			String sqlstr="update [table] set string=? where id=?";
			pstmt=conn.prepareStatement(sqlstr);
			pstmt.setString(1, str);
			pstmt.setInt(2, id);
			pstmt.executeQuery();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}
	public void close(){
		con.close();
	}
}
