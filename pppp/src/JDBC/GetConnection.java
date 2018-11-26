package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private Connection con;
	private String user = "sa";
	private String password = "123456";
	private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Project2";
	public GetConnection() {
		try {
			Class.forName(className);			
		}catch(ClassNotFoundException e) {
			System.out.println("����������ʧ��!");
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		try {
			con = DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	public void closed() {
		try {
			if(con != null) {
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("�ر����ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}

