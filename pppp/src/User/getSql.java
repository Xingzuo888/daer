package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.GetConnection;
import Model.Book;
import Model.Reader;
import Model.Br;

public class getSql {
	GetConnection connection = new GetConnection();//获取连接sql
	Connection conn = connection.getCon();
	public boolean addBook(Book book)//添加图书
	{               
		try {
			String sql = "insert into book(Bname,publish,author,price) values(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, book.getBname());//设置?中的信息
			statement.setString(2, book.getBpublish());
			statement.setString(3, book.getBauthor());
			statement.setFloat(4, book.getBprice());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateBook(Book book)//更新图书信息
	{
		try {
			String sql = "update book set Bname = ?,publish = ?,author = ?,price = ? where Bid = ?";//
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, book.getBname());
			statement.setString(2, book.getBpublish());
			statement.setString(3, book.getBauthor());
			statement.setFloat(4, book.getBprice());
			statement.setInt(5, book.getBno());
			statement.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteBook(int bid) {//删除图书 
		try {
			String sql = "delete book where Bid = ?";//设置数据库语句
			PreparedStatement statement = conn.prepareStatement(sql);//预处理sql语句
			statement.setInt(1, bid);//设置？值
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean addReader(Reader reader)//添加读者
	{               
		try {
			String sql = "insert into Reader(Rname,sex,age,jobs) values(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, reader.getRname());//设置?中的信息
			statement.setString(2, reader.getRsex());
			statement.setInt(3, reader.getRage());
			statement.setString(4, reader.getRjob());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateReader(Reader reader)//更新图书信息
	{
		try {
			String sql = "update Reader set Rname = ?,sex = ?,age = ?,jobs = ? where Rid = ?";//
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, reader.getRname());
			statement.setString(2, reader.getRsex());
			statement.setInt(3, reader.getRage());
			statement.setString(4, reader.getRjob());
			statement.setInt(5, reader.getRid());
			statement.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteReader(int rid) {//删除读者
		try {
			String sql = "delete Reader where Rid = ?";//设置数据库语句
			PreparedStatement statement = conn.prepareStatement(sql);//预处理sql语句
			statement.setInt(1, rid);//设置？值
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Book> selectAllBook(){
		ArrayList<Book> bookArray = null;
		try {
			String sql = "select * from book";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rest = statement.executeQuery();
			bookArray = new ArrayList<>();
			Book book = null;
			while(rest.next()){
				book = new Book();
				book.setBno(rest.getInt(1));
				book.setBname(rest.getString(2));
				book.setBpublish(rest.getString(3));
				book.setBauthor(rest.getString(4));
				book.setBprice(rest.getFloat(5));
				book.setBborrow(rest.getInt(6));
				bookArray.add(book);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return bookArray;
	}
	public ArrayList<Book> selectBookName(String bname) {//查找图书信息 可能有多个所以就用ArryList<book>
		ArrayList<Book> bookArray = null;
		try {
			String sql = "select * from book where Bname =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, bname);
			ResultSet rest = statement.executeQuery();
			bookArray = new ArrayList<>();
			Book book = null;
			while(rest.next()){
				book = new Book();
				book.setBno(rest.getInt(1));
				book.setBname(rest.getString(2));
				book.setBpublish(rest.getString(3));
				book.setBauthor(rest.getString(4));
				book.setBprice(rest.getFloat(5));
				book.setBborrow(rest.getInt(6));
				bookArray.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bookArray;
	}
	public Book selectBookId(int bid) {
		Book book = null;
		try {
			String sql = "select * from book where Bid = ?";
			PreparedStatement statement =conn.prepareStatement(sql);
			statement.setInt(1, bid);
			ResultSet rest = statement.executeQuery();
			while(rest.next()) {
				book = new Book();
				book.setBno(rest.getInt(1));
				book.setBname(rest.getString(2));
				book.setBpublish(rest.getString(3));
				book.setBauthor(rest.getString(4));
				book.setBprice(rest.getFloat(5));
				book.setBborrow(rest.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	public ArrayList<Reader> selectAllReader(){
		ArrayList<Reader> readerArray = null;
		try {
			String sql = "select * from Reader";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rest = statement.executeQuery();
			readerArray = new ArrayList<>();
			Reader reader = null;
			while(rest.next()){
				reader = new Reader();
				reader.setRid(rest.getInt(1));
				reader.setRname(rest.getString(2));
				reader.setRsex(rest.getString(3));
				reader.setRage(rest.getInt(4));
				reader.setRjob(rest.getString(5));
				reader.setRnumber(rest.getInt(6));
				readerArray.add(reader);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return readerArray;
	}
	public ArrayList<Reader> selectReaderName(String rname) {//查找图书信息 可能有多个所以就用ArryList<book>
		ArrayList<Reader> readerArray = null;
		try {
			String sql = "select * from Reader where Rname = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, rname);
			ResultSet rest = statement.executeQuery();
			readerArray = new ArrayList<>();
			Reader reader = null;
			while(rest.next()){
				reader = new Reader();
				reader.setRid(rest.getInt(1));
				reader.setRname(rest.getString(2));
				reader.setRsex(rest.getString(3));
				reader.setRage(rest.getInt(4));
				reader.setRjob(rest.getString(5));
				reader.setRnumber(rest.getInt(6));
				readerArray.add(reader);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return readerArray;
	}
	public Reader selectReaderId(int rid) {
		Reader reader = null;
		try {
			String sql = "select * from Reader where Rid = ?";
			PreparedStatement statement =conn.prepareStatement(sql);
			statement.setInt(1, rid);
			ResultSet rest = statement.executeQuery();
			while(rest.next()) {
				reader = new Reader();
				reader.setRid(rest.getInt(1));
				reader.setRname(rest.getString(2));
				reader.setRsex(rest.getString(3));
				reader.setRage(rest.getInt(4));
				reader.setRjob(rest.getString(5));
				reader.setRnumber(rest.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reader;
	}
	public Br selectBr(int rno,int bno) {
		Br br = null;
		try {
			String sql = "select Br.Rid,Rname,Br.Bid,Bname,bdate,rdate,fun from Br,book,reader where Br.Bid = book.Bid and Br.rid = reader.Rid and Br.Rid = ? and Br.Bid =? and rdate is null";
			PreparedStatement statement = conn.prepareStatement(sql);//预处理sql语句
			statement.setInt(1, rno);
			statement.setInt(2, bno);
			ResultSet rest = statement.executeQuery();
			while(rest.next()) {
				br = new Br();
				br.setRid(rest.getInt(1));
				br.setRname(rest.getString(2));
				br.setBid(rest.getInt(3));
				br.setBname(rest.getString(4));
				br.setBdate(String.valueOf(rest.getDate(5)));
				br.setRdate(String.valueOf(rest.getDate(6)));
				br.setFun(rest.getFloat(7));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return br;
	}
	public boolean borrow(int rno, int bno){//添加借书记录
		try{
			String sql = "insert into Br(Bid,Rid,bdate) values(?,?,Getdate())";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, bno);
			statement.setInt(2, rno);
			statement.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean reBook(int rno,int bno){
		try{
			String sql = "update Br set rdate = Getdate() where Bid=? and Rid=? and rdate is null";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, bno);
			statement.setInt(2, rno);
			statement.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Reader> getAllReader(){//查询全部读者信息
		ArrayList<Reader> ReaderArray = null;
		try {
			String sql = "select * from Reader";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rest = statement.executeQuery();
			ReaderArray = new ArrayList<>();
			Reader Reader = null;
			while(rest.next()){
				Reader = new Reader();
				Reader.setRid(rest.getInt(1));
				Reader.setRname(rest.getString(2));
				Reader.setRsex(rest.getString(3));
				Reader.setRage(rest.getInt(4));
				Reader.setRjob(rest.getString(5));
				Reader.setRnumber(rest.getInt(6));
				ReaderArray.add(Reader);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return ReaderArray;
	}
	
	public ArrayList<Br> getAllBr(){//查询全部借书记录
		ArrayList<Br> BrArray = null;
		try {
			String sql = "select * from Br";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rest = statement.executeQuery();
			BrArray = new ArrayList<>();
			Br Br = null;
			while(rest.next()){
				Br = new Br();
				Br.setRid(rest.getInt(1));
				Br.setBid(rest.getInt(2));
				Br.setBdate(rest.getString(3));
				Br.setRdate(rest.getString(4));
				Br.setFun(rest.getFloat(5));
				BrArray.add(Br);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return BrArray;
	}
	
	
	public  ResultSet query() throws SQLException{//
		
		Statement stmt=conn.createStatement();
		
		return stmt.executeQuery("select * from book");
	}

	public  ResultSet read() throws SQLException{//
		
		Statement stmt=conn.createStatement();
		
		return stmt.executeQuery("select * from reader");
	}
	
	public void closeSql1() {
		try{
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}  
	
	public  ResultSet Br() throws SQLException{
		
		Statement stmt=conn.createStatement();
		
		return stmt.executeQuery("select * from Br");
	}
	
	public void closeSql2() {
		try{
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}  
	
	public  ArrayList<Br> selectFun(){//超期未还的
		ArrayList<Br>	brArray = null;
		try {
			String sql = "select *from(select br.rid,rname,br.bid,bname,bdate,rdate,fun from br,book,reader where br.rid = reader.rid and br.bid = book.bid )x where fun > 0 or (datediff(day,bdate,Getdate()) > 30 and rdate is null)";
			PreparedStatement statement = conn.prepareStatement(sql);//预处理sql语句
			ResultSet rest = statement.executeQuery();//执行sql语句
			brArray = new ArrayList<>();
			Br br = null;
			while(rest.next()) {
				br = new Br();
				br.setRid(rest.getInt(1));
				br.setRname(rest.getString(2));
				br.setBid(rest.getInt(3));
				br.setBname(rest.getString(4));
				br.setBdate(rest.getString(5));
				br.setRdate(rest.getString(6));
				br.setFun(rest.getFloat(7));
				brArray.add(br);
			}
			return brArray;
		}catch(SQLException e) {
			e.printStackTrace();
			return brArray;
		}
	}
	
	public void closeSql3() {
		try{
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public  ArrayList<Br> borrowed(){//全部借书记录
		ArrayList<Br>	BrArray = null;
		try {
			String sql = "select Br.Rid,Rname,Br.bid,bname,bdate from book,Br,Reader where br.Bid=book.Bid and br.Rid=Reader.Rid and borrowed='0'and rdate is null";
			PreparedStatement statement = conn.prepareStatement(sql);//预处理sql语句
			ResultSet rest = statement.executeQuery();//执行sql语句
			BrArray = new ArrayList<>();
			Br Br = null;
			while(rest.next()) {
				Br = new Br();
				Br.setRid(rest.getInt(1));
				Br.setRname(rest.getString(2));
				Br.setBid(rest.getInt(3));
				Br.setBname(rest.getString(4));
				Br.setBdate(rest.getString(5));
				BrArray.add(Br);
			}
			return BrArray;
		}catch(SQLException e) {
			e.printStackTrace();
			return BrArray;
		}
	}
	
	public void closeSql4() {
		try{
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Book> selectPublish(String publish) {//查询图书的出版社
		ArrayList<Book>	BookArray = new ArrayList<>();
		try {
			String sql = "select * from book where publish = ?";
			PreparedStatement statement = conn.prepareStatement(sql);//预处理
			statement.setString(1, publish);
			ResultSet re = statement.executeQuery();//执行
			Book book=null;
			while(re.next()) {
				book = new Book();
				book.setBno(re.getInt(1));
				book.setBname(re.getString(2));
				book.setBpublish(re.getString(3));
				book.setBauthor(re.getString(4));
				book.setBprice(re.getFloat(5));
				book.setBborrow(re.getInt(6));
				BookArray.add(book);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return BookArray;
	}
	public ArrayList<Br> selectredaerbook(String name){//查询某读者借的书
		ArrayList<Br> BrArray = null;
		try {
			String sql = "select Rname,Br.Rid,Br.Bid,Bname,bdate,rdate from Br,Book,Reader where Br.rid=Reader.Rid and Br.Bid=Book.Bid  and Rname=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rest = statement.executeQuery();
			BrArray = new ArrayList<>();
			Br Br = null;
			while(rest.next()){
				Br = new Br();
				Br.setRname(rest.getString(1));
				Br.setRid(rest.getInt(2));
				Br.setBid(rest.getInt(3));
				Br.setBname(rest.getString(4));
				Br.setBdate(rest.getString(5));
				Br.setRdate(rest.getString(6));
				BrArray.add(Br);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return BrArray;
	}
	
	
	public ArrayList<Br> selectrdate(String bname ,String rname){//查询某读者归还的日期
		ArrayList<Br> BrArray = null;
		try {
			String sql = "select Rname,Br.Rid,Bname,bdate,rdate from Br,Reader,Book where Br.Bid=book.Bid and Br.Rid=Reader.Rid and Rname=? and Bname=? and rdate is not Null";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, bname);
			statement.setString(2, rname);
			ResultSet rest = statement.executeQuery();
			BrArray = new ArrayList<>();
			Br Br = null;
			while(rest.next()){
				Br = new Br();
				Br.setRname(rest.getString(1));
				Br.setRid(rest.getInt(2));
				Br.setBname(rest.getString(3));
				Br.setBdate(rest.getString(4));
				Br.setRdate(rest.getString(5));
				BrArray.add(Br);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return BrArray;
			}
		
	
	
	
	public ArrayList<Br> sumfun(String name) {//查询罚款总额
		ArrayList<Br> BrArray = null;
		try {
			String sql = "select Rname,Reader.Rid,sum(fun) from Br,book,Reader where Br.Bid=book.Bid and Br.Rid=Reader.Rid and Rname= ? group by Reader.Rname,Reader.Rid";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rest = statement.executeQuery();
			BrArray = new ArrayList<>();
			Br Br = null;
			while(rest.next()){
				Br = new Br();
				Br.setRname(rest.getString(1));
				Br.setRid(rest.getInt(2));
				Br.setFun(rest.getFloat(3));
				BrArray.add(Br);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return BrArray;
	}
	public void closeSql() {
			try{
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}  
}

