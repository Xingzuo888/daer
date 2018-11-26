package Book;

public class book {

	private Integer bno;//图书编号
	private String bname;//图书名字
	private String bpublish;//图书出版社
	private String bauthor;//图书作者
	private float bprice;//图书价格
	private int bborrow;//图书库存  0已借出 1没有借出
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBpublish() {
		return bpublish;
	}
	public void setBpublish(String bpublish) {
		this.bpublish = bpublish;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public float getBprice() {
		return bprice;
	}
	public void setBprice(float bprice) {
		this.bprice = bprice;
	}
	public int getBborrow() {
		return bborrow;
	}
	public void setBborrow(int bborrow) {
		this.bborrow = bborrow;
	}
	

}
