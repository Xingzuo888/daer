package JDBC_dengluxitong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private static final String user="sa";
	private static final String password="123456";
	private static final String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://localhost:1433;DatabaseName=YongHu";
	private static Connection conn=null;
	
	public static Connection GetConnection(){
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建数据库连接失败！");
			conn=null;
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closed(){
		try{
			conn.close();
			
		}catch(SQLException e){
			System.out.println("关闭数据库连接失败！");
			e.printStackTrace();
		}
	}
}
