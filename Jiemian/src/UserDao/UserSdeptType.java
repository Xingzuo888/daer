package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.SdeptTypeModel;
import Util.StringUtil;

public class UserSdeptType {

	/**
	 * ���ϵ��
	 * @param conn
	 * @param sdeptType
	 * @throws Exception 
	 * @throws Exception
	 */
	public int add(Connection conn,SdeptTypeModel sdeptType) throws Exception{
		String sql="insert into sdeptType(sdeptName,sdeptDes) values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, sdeptType.getSdeptName());
		pstmt.setString(2, sdeptType.getSdeptDes());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ϵ�𡪡����Ʋ�ѯ
	 * @param conn
	 * @param sdeptType
	 * @return
	 * @throws Exception
	 */
	public boolean select(Connection conn,SdeptTypeModel sdeptType) throws Exception{
		String sql="select * from sdeptType where sdeptName=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sdeptType.getSdeptName());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ��ѯϵ����ӵ������˵�
	 * @param conn
	 * @param sdeptTypeModel
	 * @return
	 * @throws Exception
	 */
	public static ResultSet comboBoxList(Connection conn,SdeptTypeModel sdeptTypeModel) throws Exception{
		String sql="select * from sdeptType";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		return rs;
	}
	
	/**
	 * ��ѯϵ����ӵ������
	 * @param conn
	 * @param sdeptType
	 * @return
	 * @throws Exception
	 */
	public ResultSet select_Table(Connection conn,SdeptTypeModel sdeptType) throws Exception{
		StringBuffer sb= new StringBuffer("select * from sdeptType");
		if(StringUtil.isNotEmpty(sdeptType.getSdeptName())){
			sb.append(" and sdeptName like '%"+sdeptType.getSdeptName()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * �޸�����
	 * @param conn
	 * @param sdeptType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,SdeptTypeModel sdeptType) throws Exception{
		String sql="update sdeptType set sdeptName=?,sdeptDes=? where sdeptId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sdeptType.getSdeptName());
		pstmt.setString(2, sdeptType.getSdeptDes());
		pstmt.setInt(3, sdeptType.getSdeptId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ɾ������
	 * @param conn
	 * @param sdeptId
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn, int sdeptId) throws Exception{
		String sql="delete from sdeptType where sdeptId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, sdeptId);
		return pstmt.executeUpdate();
	}
}
