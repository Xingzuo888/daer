package 垃圾;

import java.util.ArrayList;
import java.util.Date;

public class Java_program {
	public static void main(String[] args){
		Account account = new Account("张良",139876,10000);
		account.setAnnualInterestRate(0.025);
		account.deposit(300);
		account.deposit(400);
		account.deposit(500);
		account.withDraw(50);
		account.withDraw(200);
		account.withDraw(120);
		System.out.println("**************************");
		System.out.println("*账户号："+account.getId());
		System.out.println("*账户名："+account.getName());
		System.out.println("*开户日期："+account.getDateCreated());
		System.out.println("*该账户年利率："+account.getAnnualInterestRate());
		System.out.println("*该账户余额："+account.getBalance());
		if(!account.transcation.isEmpty())
			for(int i=0;i<account.transcation.size();i++)
			{
				account.transcation.get(i).getMoney();
			}
		System.out.println("**************************");	
	}
}

class Account{
	private int id = 0;     //账户的ID号
	private String name;    //账户的姓名
	private double balance = 0;  //账户的余额
	private double annualInterestRate = 0;  //年利率，假设所有的账户都有相同的年利率。
	private Date dateCreated;    //账户的开户日期
	//无参构造法
	public Account(){
		dateCreated = new Date();
	}
	//创建带特定id和初始余额的账户的构造方法
	public Account(int id,double balance){
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	
	//创建一个具有指定名字、id、和余额的账户的构造方法
	public Account(String name,int id,double balance){
		this.name = name;
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}
	
	//创建一个名为transactions的ArrayList类型的数据域，用于为账户存储交易，每笔交易都是一个Transaction类的实例。
	ArrayList<Transcation> transcation = new ArrayList<>();
	
	//创建名为withDraw的方法，从账户提取特定数额，向transactions数组线性表添加一笔交易
	public void withDraw(double money){
		this.balance -= money;
		transcation.add(new Transcation(0,money));
	}
	
	//创建名为deposit的方法，从账户存储特定数额，向transactions数组线性表添加一笔交易
	public void deposit(double money){
		this.balance += money;
		transcation.add(new Transcation(money,0));
	}
}
//创建一个交易类
 class Transcation {
	 double inMoney=0;//存入的金额
	 double outMoney=0;//取出的金额
			 public Transcation() {};
	 public Transcation(double inMoney,double outMoney) {
		 this.inMoney=inMoney;
		 this.outMoney=outMoney;
	 }
	 //打印交易的金额
	 public void getMoney() {
	 if(inMoney!=0)
		System.out.println("*存入"+inMoney);
	 if(outMoney!=0)
		System.out.println("*取入"+outMoney);
	 }
 }


