package ����;

import java.util.ArrayList;
import java.util.Date;

public class Java_program {
	public static void main(String[] args){
		Account account = new Account("����",139876,10000);
		account.setAnnualInterestRate(0.025);
		account.deposit(300);
		account.deposit(400);
		account.deposit(500);
		account.withDraw(50);
		account.withDraw(200);
		account.withDraw(120);
		System.out.println("**************************");
		System.out.println("*�˻��ţ�"+account.getId());
		System.out.println("*�˻�����"+account.getName());
		System.out.println("*�������ڣ�"+account.getDateCreated());
		System.out.println("*���˻������ʣ�"+account.getAnnualInterestRate());
		System.out.println("*���˻���"+account.getBalance());
		if(!account.transcation.isEmpty())
			for(int i=0;i<account.transcation.size();i++)
			{
				account.transcation.get(i).getMoney();
			}
		System.out.println("**************************");	
	}
}

class Account{
	private int id = 0;     //�˻���ID��
	private String name;    //�˻�������
	private double balance = 0;  //�˻������
	private double annualInterestRate = 0;  //�����ʣ��������е��˻�������ͬ�������ʡ�
	private Date dateCreated;    //�˻��Ŀ�������
	//�޲ι��취
	public Account(){
		dateCreated = new Date();
	}
	//�������ض�id�ͳ�ʼ�����˻��Ĺ��췽��
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
	
	//����һ������ָ�����֡�id���������˻��Ĺ��췽��
	public Account(String name,int id,double balance){
		this.name = name;
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}
	
	//����һ����Ϊtransactions��ArrayList���͵�����������Ϊ�˻��洢���ף�ÿ�ʽ��׶���һ��Transaction���ʵ����
	ArrayList<Transcation> transcation = new ArrayList<>();
	
	//������ΪwithDraw�ķ��������˻���ȡ�ض������transactions�������Ա����һ�ʽ���
	public void withDraw(double money){
		this.balance -= money;
		transcation.add(new Transcation(0,money));
	}
	
	//������Ϊdeposit�ķ��������˻��洢�ض������transactions�������Ա����һ�ʽ���
	public void deposit(double money){
		this.balance += money;
		transcation.add(new Transcation(money,0));
	}
}
//����һ��������
 class Transcation {
	 double inMoney=0;//����Ľ��
	 double outMoney=0;//ȡ���Ľ��
			 public Transcation() {};
	 public Transcation(double inMoney,double outMoney) {
		 this.inMoney=inMoney;
		 this.outMoney=outMoney;
	 }
	 //��ӡ���׵Ľ��
	 public void getMoney() {
	 if(inMoney!=0)
		System.out.println("*����"+inMoney);
	 if(outMoney!=0)
		System.out.println("*ȡ��"+outMoney);
	 }
 }


