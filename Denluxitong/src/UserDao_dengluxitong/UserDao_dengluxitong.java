package UserDao_dengluxitong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JDBC_dengluxitong.JDBC;
import User_dengluxitong.User_dengluxitong;

public class UserDao_dengluxitong {

	public void Add_dengluxitong(User_dengluxitong u) throws SQLException{
		Connection conn=JDBC.GetConnection();
		String sql="insert into denglu(Id,Code,Mold,Num)"+"values(?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, u.getID());
		ps.setString(2, u.getCODE());
		ps.setString(3, u.getMOLD());
		ps.setInt(4, u.getNUM());
		ps.execute();
		JDBC jdbc=new JDBC();
		jdbc.closed();
	}
	
	public List<User_dengluxitong> query() throws SQLException{
		Connection conn=JDBC.GetConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select Id,Code,Mold,Num from denglu");
		
		List<User_dengluxitong> ls=new ArrayList<User_dengluxitong>();
		User_dengluxitong user=null;
		while(rs.next()){
			user=new User_dengluxitong();
			user.setID(rs.getString("Id"));
			user.setCODE(rs.getString("Code"));
			user.setMOLD(rs.getString("Mold"));
			user.setNUM(rs.getInt("Num"));
			ls.add(user);
		}
		JDBC jdbc=new JDBC();
		jdbc.closed();
		return ls;
	}
}
