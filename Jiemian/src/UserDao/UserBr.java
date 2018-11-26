package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.BookModel;
import Model.BrModel;
import Model.ReaderModel;
import Util.StringUtil;

public class UserBr {

	/**
	 * 添加借阅记录
	 * @param conn
	 * @param brModel
	 * @throws Exception 
	 */
	public int add(Connection conn,BrModel brModel) throws Exception{
		String sql="insert into br(readerId,bookId,bdate) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, brModel.getReaderId());
		pstmt.setInt(2, brModel.getBookId());
		pstmt.setString(3, brModel.getBdate());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询并添加表格
	 * @param conn
	 * @param readerModel
	 * @param bookModel
	 * @param brModel
	 * @return
	 * @throws Exception
	 */
	public ResultSet select_Table(Connection conn,ReaderModel readerModel,BookModel bookModel,BrModel brModel) throws Exception{
		StringBuffer sb=new StringBuffer("select * from v1");
		if(brModel.getReaderId()!=null){
			sb.append(" and readerId like '%"+brModel.getReaderId()+"%'");
		}
		if(StringUtil.isNotEmpty(readerModel.getReaderName())){
			sb.append(" and readerName like '%"+readerModel.getReaderName()+"%'");
		}
		if(brModel.getBookId()!=null){
			sb.append(" and bookId like '%"+brModel.getBookId()+"%'");
		}
		if(StringUtil.isNotEmpty(bookModel.getBookName())){
			sb.append(" and bookName like '%"+bookModel.getBookName()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 还书
	 * @param conn
	 * @param brModel
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,BrModel brModel) throws Exception{
		String sql="update br set rdate=?,fun=? where brId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, brModel.getRdate());
		pstmt.setDouble(2, brModel.getFun());
		pstmt.setInt(3, brModel.getBrId());
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection conn,int brId) throws Exception{
		String sql="delete from br where brId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, brId);
		return pstmt.executeUpdate();
	}
}
