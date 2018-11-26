package Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import Book.book;
import Userdao.userdao;

public class test {

	public static void main(String[] args) {
		userdao u=new userdao();
		Vector<book> b = new Vector<>();
		try {
			b = u.query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (book book : b) {
			System.out.println(book.getBno()+book.getBname()+book.getBpublish()+book.getBauthor()+book.getBprice()+book.getBborrow());
		}
	}
	
	
}
