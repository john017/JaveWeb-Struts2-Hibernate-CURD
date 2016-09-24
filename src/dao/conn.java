package dao;
import java.sql.*;

public class conn {
	public Connection con;
	private String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CURD_test";
	private String user="sa",pw="sa";
	public void connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(url,user,pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
