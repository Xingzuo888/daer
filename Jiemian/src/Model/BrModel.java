package Model;

import java.util.Date;

public class BrModel {

	private Integer brId;
	private Integer readerId;
	private Integer bookId;
	private String bdate;
	private String rdate;
	private double fun;
	
	public BrModel() {
		super();
	}
	
	
	public BrModel(Integer readerId, Integer bookId) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
	}


	public BrModel(Integer readerId, Integer bookId, String bdate) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
		this.bdate = bdate;
	}
	
	
	public BrModel(Integer brId, String rdate, double fun) {
		super();
		this.brId = brId;
		this.rdate = rdate;
		this.fun = fun;
	}


	public Integer getBrId() {
		return brId;
	}


	public void setBrId(Integer brId) {
		this.brId = brId;
	}


	public Integer getReaderId() {
		return readerId;
	}
	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public double getFun() {
		return fun;
	}
	public void setFun(double fun) {
		this.fun = fun;
	}
}
