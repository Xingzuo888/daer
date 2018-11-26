package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LianjieUtil {

	private static final String user="sa";
	private static final String password="123456";
	private static final String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://localhost:1433;DatabaseName=jiemian";
	private static Connection conn=null;
	
	public LianjieUtil(){
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动库	失败！");
			e.printStackTrace();
		}
	}
	
	public Connection GetConnection(){
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			e.printStackTrace();
		}
		return conn;
	}
	
	public void Close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭数据库失败！");
			e.printStackTrace();
		}
	}
}
