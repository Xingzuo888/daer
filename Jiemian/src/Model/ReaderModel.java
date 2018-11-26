package Model;

public class ReaderModel {

	private Integer readerId;
	private String readerName;
	private String sex;
	private Integer age;
	private String sdept;
	private Integer bamount;
	private Double allFun;

	public ReaderModel() {
		super();
	}
	
	public ReaderModel(Integer readerId) {
		super();
		this.readerId = readerId;
	}
	
	
	public ReaderModel(Integer readerId, Double allFun) {
		super();
		this.readerId = readerId;
		this.allFun = allFun;
	}

	public ReaderModel(Integer readerId, String readerName) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
	}

	public ReaderModel(Integer readerId, String readerName, String sex, String sdept) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		this.sex = sex;
		this.sdept = sdept;
	}
	
	public ReaderModel(Integer readerId, String readerName, String sex, Integer age, String sdept) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		this.sex = sex;
		this.age = age;
		this.sdept = sdept;
	}
	
	public Integer getReaderId() {
		return readerId;
	}
	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public Integer getBamount() {
		return bamount;
	}
	public void setBamount(Integer bamount) {
		this.bamount = bamount;
	}
	public Double getAllFun() {
		return allFun;
	}
	public void setAllFun(Double allFun) {
		this.allFun = allFun;
	}
}
