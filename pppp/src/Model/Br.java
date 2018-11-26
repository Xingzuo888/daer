package Model;

public class Br {//读者信息类
	private Integer rid;//读者编号
	private String rname;//读者名字
	private Integer bid;//图书编号
	private String bname;//书名
	private String bdate;//结束时间
	private String rdate;//还书时间
	private float fun;//罚款
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
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
	public float getFun() {
		return fun;
	}
	public void setFun(float fun) {
		this.fun = fun;
	}
	
}
