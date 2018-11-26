package Model;


public class BookModel {

	private Integer bookId;
	private String bookName;
	private String author;
	private String publish;
	private String pubDate;
	private Double price;
	private Integer stock;
	
	public BookModel() {
		super();
	}
	
	public BookModel(Integer bookId) {
		super();
		this.bookId = bookId;
	}

	
	public BookModel(Integer bookId, String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}

	public BookModel(Integer bookId, String bookName, String author, String publish) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publish = publish;
	}

	public BookModel(Integer bookId, String bookName, String author, String publish, String pubDate, Double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publish = publish;
		this.pubDate = pubDate;
		this.price = price;
	}
	
	public BookModel(Integer bookId, String bookName, String author, String publish, String pubDate, Double price,
			Integer stock) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publish = publish;
		this.pubDate = pubDate;
		this.price = price;
		this.stock = stock;
	}

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
