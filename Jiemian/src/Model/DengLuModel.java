package Model;

public class DengLuModel {

	private Integer id;
	private String zhanghu;
	private String mima;
	
	
	public DengLuModel() {
		super();
	}
	
	public DengLuModel(String zhanghu, String mima) {
		super();
		this.zhanghu = zhanghu;
		this.mima = mima;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
		
}
