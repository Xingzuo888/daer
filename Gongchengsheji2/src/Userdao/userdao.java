package Userdao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Book.book;
import JDBC.jdbc;

public class userdao {

	public  ResultSet query() throws SQLException{
		Connection conn=jdbc.GetConnection();
		Statement stmt=conn.createStatement();
		
		return stmt.executeQuery("select * from book");
	}
	
	public  ResultSet query(int id) throws SQLException{
		Connection conn=jdbc.GetConnection();
		Statement stmt=conn.createStatement();
		
		return stmt.executeQuery("select * from book where Bid="+id);
	}
}
