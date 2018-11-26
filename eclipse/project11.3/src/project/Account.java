package project;

public class Account {
	private int id;
	private double balance;
	private static double annualInterestRate;//当前利率
	private java.util.Date dateCreated;
	
	public Account() {
		dateCreated = new java.util.Date();
	}
	
	public Account(int id,double balance){
		this.id = id;
		this.balance = balance;
		dateCreated = new java.util.Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		Account.annualInterestRate = annualInterestRate;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	//返回月利率
	public double getMonthlyInteRest(double annualInterestRate) {
		double MonthlyInteRest = (annualInterestRate / 100) / 12;
		return this.balance*MonthlyInteRest;
	}
	
	//从账户提取特定数额
	public double withDraw(double money){
		this.balance -= money;
		return this.balance;
	}
	
	//向账户存储特定数额
	public double deposit(double money){
		this.balance += money;
		return this.balance;
	}

}
