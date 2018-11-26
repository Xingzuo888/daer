package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.BookModel;
import Util.StringUtil;

public class UserBook {

	/**
	 * 添加图书信息
	 * @param conn
	 * @param bookModel
	 * @return
	 * @throws Exception 
	 */
	public int add(Connection conn,BookModel bookModel) throws Exception{
		String sql="insert into book(bookId,bookName,author,publish,pubDate,price) values(?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bookModel.getBookId());
		pstmt.setString(2, bookModel.getBookName());
		pstmt.setString(3, bookModel.getAuthor());
		pstmt.setString(4, bookModel.getPublish());
		pstmt.setString(5, bookModel.getPubDate());
		pstmt.setDouble(6, bookModel.getPrice());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 添加图书或还书sstock加一
	 * @param conn
	 * @param bookModel
	 * @return
	 * @throws Exception 
	 */
	public int addStock(Connection conn,BookModel bookModel) throws Exception{
		String sql="update book set stock=stock+1 where bookId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookModel.getBookId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 借阅stock减一
	 * @param conn
	 * @param bookModel
	 * @throws Exception
	 */
	public int subStock(Connection conn,BookModel bookModel) throws Exception{
		String sql="update book set stock=stock-1 where bookId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookModel.getBookId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书——查询库存量是否需要加一
	 * @param conn
	 * @param bookModel
	 * @return
	 * @throws Exception
	 */
	public boolean selectAdd(Connection conn,BookModel bookModel) throws Exception{
		String sql="select * from book where bookId=? and bookName=? and author=? and publish=? and pubDate=? and price=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bookModel.getBookId());
		pstmt.setString(2, bookModel.getBookName());
		pstmt.setString(3, bookModel.getAuthor());
		pstmt.setString(4, bookModel.getPublish());
		pstmt.setString(5, bookModel.getPubDate());
		pstmt.setDouble(6, bookModel.getPrice());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询书号
	 */
	public BookModel selectBookId(Connection conn,BookModel bookModel) throws Exception{
		BookModel result=null;
		String sql="select * from book where bookId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bookModel.getBookId());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			result=new BookModel();
			result.setBookId(rs.getInt("bookId"));
			result.setBookName(rs.getString("bookName"));
			result.setAuthor(rs.getString("author"));
			result.setPublish(rs.getString("publish"));
			result.setPubDate(rs.getString("pubDate"));
			result.setPrice(rs.getDouble("price"));
			result.setStock(rs.getInt("stock"));
		}
		return result;
	}
	
	/**
	 * 查询并添加表格
	 * @param conn
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static ResultSet select_Table(Connection conn,BookModel bookModel) throws Exception{
		StringBuffer sb=new StringBuffer("select * from book");
		if(bookModel.getBookId()!=null){
			sb.append(" and bookId like '%"+bookModel.getBookId()+"%'");
		}
		if(StringUtil.isNotEmpty(bookModel.getBookName())){
			sb.append(" and bookName like '%"+bookModel.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(bookModel.getAuthor())){
			sb.append(" and author like '%"+bookModel.getAuthor()+"%'");
		}
		if(StringUtil.isNotEmpty(bookModel.getPublish())){
			sb.append(" and publish like '%"+bookModel.getPublish()+"%'");
		}

		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 修改数据
	 * @param conn
	 * @param bookModel
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn,BookModel bookModel) throws Exception{
		String sql="update book set bookName=?,author=?,publish=?,pubDate=?,price=?,stock=? where bookId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bookModel.getBookName());
		pstmt.setString(2, bookModel.getAuthor());
		pstmt.setString(3, bookModel.getPublish());
		pstmt.setString(4, bookModel.getPubDate());
		pstmt.setDouble(5, bookModel.getPrice());
		pstmt.setInt(6, bookModel.getStock());
		pstmt.setInt(7, bookModel.getBookId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 删除数据
	 * @param conn
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn,int bookId) throws Exception{
		String sql="delete from book where bookId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, bookId);
		return pstmt.executeUpdate();
	}
}
