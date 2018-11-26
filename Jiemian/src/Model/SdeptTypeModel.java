package Model;

public class SdeptTypeModel {

	private Integer sdeptId;
	private String sdeptName;
	private String sdeptDes;
	
	public SdeptTypeModel() {
		super();
	}
	public SdeptTypeModel(String sdeptName, String sdeptDes) {
		super();
		this.sdeptName = sdeptName;
		this.sdeptDes = sdeptDes;
	}
	public SdeptTypeModel(Integer sdeptId, String sdeptName, String sdeptDes) {
		super();
		this.sdeptId = sdeptId;
		this.sdeptName = sdeptName;
		this.sdeptDes = sdeptDes;
	}
	public Integer getSdeptId() {
		return sdeptId;
	}
	public void setSdeptId(Integer sdeptId) {
		this.sdeptId = sdeptId;
	}
	public String getSdeptName() {
		return sdeptName;
	}
	public void setSdeptName(String sdeptName) {
		this.sdeptName = sdeptName;
	}
	public String getSdeptDes() {
		return sdeptDes;
	}
	public void setSdeptDes(String sdeptDes) {
		this.sdeptDes = sdeptDes;
	}
	@Override
	public String toString() {
		return sdeptName;
	}
	
}
