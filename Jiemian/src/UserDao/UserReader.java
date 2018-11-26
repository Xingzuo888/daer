package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.ReaderModel;
import Util.StringUtil;

public class UserReader {

	
	/**
	 * ��Ӷ���
	 * @param conn
	 * @param readerModel
	 * @return
	 * @throws Exception 
	 */
	public int add(Connection conn,ReaderModel readerModel) throws Exception{
		String sql="insert into reader(readerId,readerName,sex,age,sdept) values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, readerModel.getReaderId());
		pstmt.setString(2, readerModel.getReaderName());
		pstmt.setString(3, readerModel.getSex());
		pstmt.setInt(4, readerModel.getAge());
		pstmt.setString(5, readerModel.getSdept());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ��ѯѧ��
	 * @param conn
	 * @param readerModel
	 * @return
	 * @throws Exception
	 */
	public ReaderModel selectReaderId(Connection conn,ReaderModel readerModel) throws Exception{
		ReaderModel result=null;
		String sql="select * from reader where readerId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, readerModel.getReaderId());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			result=new ReaderModel();
			result.setReaderId(rs.getInt("readerId"));
			result.setReaderName(rs.getString("readerName"));
			result.setSex(rs.getString("sex"));
			result.setAge(rs.getInt("age"));
			result.setSdept(rs.getString("sdept"));
			result.setBamount(rs.getInt("bamount"));
			result.setAllFun(rs.getDouble("allFun"));
		}
		return result;
	}
	
	/**
	 * ����bamount��һ
	 * @param conn
	 * @param readerModel
	 * @throws Exception
	 */
	public int AddBamount(Connection conn,ReaderModel readerModel) throws Exception{
		String sql="update reader set bamount=bamount+1 where readerId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, readerModel.getReaderId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ����bamount��һ��allfun��һ
	 * @param conn
	 * @param readerModel
	 * @throws Exception
	 */
	public int SubBamountAndAllFun(Connection conn,ReaderModel readerModel) throws Exception{
		String sql="update reader set bamount=bamount-1,allFun=allFun+? where readerId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDouble(1, readerModel.getAllFun());
		pstmt.setInt(2, readerModel.getReaderId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ������allfun
	 * @param conn
	 * @param readerModel
	 * @throws Exception
	 */
	public int SubAllFun(Connection conn,ReaderModel readerModel) throws Exception{
		String sql="update reader set allFun=allFun-? where readerId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDouble(1, readerModel.getAllFun());
		pstmt.setInt(2, readerModel.getReaderId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ��ѯ����ӱ��
	 * @param conn
	 * @param readerModel
	 * @return
	 * @throws Exception
	 */
	public ResultSet select_Table(Connection conn,ReaderModel readerModel) throws Exception{
		StringBuffer sb=new StringBuffer("select * from reader");
		if(readerModel.getReaderId()!=null){
			sb.append(" and readerId like '%"+readerModel.getReaderId()+"%'");
		}
		if(StringUtil.isNotEmpty(readerModel.getReaderName())){
			sb.append(" and readerName like '%"+readerModel.getReaderName()+"%'");
		}
		if(StringUtil.isNotEmpty(readerModel.getSex())){
			sb.append(" and sex like '%"+readerModel.getSex()+"%'");
		}
		if(StringUtil.isNotEmpty(readerModel.getSdept())){
			sb.append(" and sdept like '%"+readerModel.getSdept()+"%'");
		}
		
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * �޸�����
	 * @param conn
	 * @param readerModel
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,ReaderModel readerModel) throws Exception{
		String sql="update reader set readerName=?,sex=?,age=?,sdept=? where readerId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, readerModel.getReaderName());
		pstmt.setString(2, readerModel.getSex());
		pstmt.setInt(3, readerModel.getAge());
		pstmt.setString(4, readerModel.getSdept());
		pstmt.setInt(5, readerModel.getReaderId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ɾ������
	 * @param conn
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn,int readerId) throws Exception{
		String sql="delete from reader where readerId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, readerId);
		return pstmt.executeUpdate();
	}
}
