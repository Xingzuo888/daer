package Model;

public class Reader {//读者信息类
	private Integer rid;//读者编号
	private String rname;//读者姓名
	private String rsex;//读者性别
	private int rage;//读者年龄
	private String rjob;//读者职业
	private int rnumber;//读者借书量
	private float rcountfun;//读者罚款
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
	public String getRsex() {
		return rsex;
	}
	public void setRsex(String rsex) {
		this.rsex = rsex;
	}
	public int getRage() {
		return rage;
	}
	public void setRage(int rage) {
		this.rage = rage;
	}
	public String getRjob() {
		return rjob;
	}
	public void setRjob(String rjob) {
		this.rjob = rjob;
	}
	public int getRnumber() {
		return rnumber;
	}
	public void setRnumber(int rnumber) {
		this.rnumber = rnumber;
	}
	public float getRCountfun() {
		return rcountfun;
	}
	public void setRCountfun(float rcountfun) {
		this.rcountfun = rcountfun;
	}
	
	
}

