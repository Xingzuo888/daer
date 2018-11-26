package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.DengLuModel;

public class UserDenglu {

	/**
	 * µÇÂ¼
	 * @param conn
	 * @param denglu
	 * @return
	 * @throws Exception
	 */
	public DengLuModel login(Connection conn,DengLuModel denglu) throws Exception{
		DengLuModel resultDenglu=null;
		String sql="select * from denglu where zhanghu=? and mima=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, denglu.getZhanghu());
		pstmt.setString(2, denglu.getMima());
		ResultSet rs= pstmt.executeQuery();
		if(rs.next()){
			resultDenglu=new DengLuModel();
			resultDenglu.setId(rs.getInt("id"));
			resultDenglu.setZhanghu(rs.getString("zhanghu"));
			resultDenglu.setMima(rs.getString("mima"));
		}
		return resultDenglu;
	}
}
