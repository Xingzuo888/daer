package ��У����Ӧ�ó���;

public class ��У����Ӧ�ó��� {
		public static void main(String[] args){
			Professor p = new Professor("jj",5000,50);         //�������ڶ��󣬲�д����Ϣ
			adjProfessor a = new adjProfessor("tt",3000,40);   //���������ڶ��󣬲�д����Ϣ
			Lecturer l = new Lecturer("qq",2000,30);           //������ʦ���󣬲�д����Ϣ
			Assistant as = new Assistant("ww",1500,20);        //�������̶��󣬲�д����Ϣ
			p.calPay(30);a.calPay(40);l.calPay(50);as.calPay(60);  //�����¿�ʱ��
			//��ӡ��ʦ���¹���
			System.out.println("����" + p.teaName + "���¹���Ϊ��" + p.getPay());
			System.out.println("������" + a.teaName + "���¹���Ϊ��" + a.getPay());
			System.out.println("��ʦ" + l.teaName + "���¹���Ϊ��" + l.getPay());
			System.out.println("����" + as.teaName + "���¹���Ϊ��" + as.getPay());
			//����ѧУ����
			School s = new School();
			s.getFees(20, 100);      //�����ܵ�ѧ��ѧ��
			s.balance();             //��ӡѧУ�˻����
			s.getPays(p,a,l,as);     //���㷢�Ž�ְ���ܵĹ���
			s.balance();             //��ӡѧУ�˻����
			
			Graduate g = new Graduate("xx",5000,20);   //�����о�������
			System.out.println("����" + g.stuName + "�о�����");
			g.calPay(30);          //  �����²������̵ĳ���
			g.loanStatus();        // ��ӡ���о����Ƿ���Ҫ�������Ҫ�����ӡ������
		}
	
}

abstract class Student {
	String stuName;    //ѧ������
	double fee;     //ÿѧ��ѧ��
}

abstract class Teacher {
	String teaName;    //��ʦ����
	double basePay;    //ÿ�¹̶�����
	double  hourlyPay;          //��ʱ��
	double  pay;             //ÿ�¹���
}

interface StudentInf {
	void setFee(double fee);     //����ÿѧ��ѧ��
	double getFee();             //��ȡÿѧ��ѧ��
}

interface TeacherInf {
	void calPay(int hour);      //���㲢�����¹���
	double getPay();             //��ȡ�¹���
}

class Graduate extends Student implements StudentInf,TeacherInf{
    double hourlyPay;           //ÿСʱ����
	double pay;             //ÿ�³���
	public Graduate( String stuName, double fee, double hourlyPay)    //���캯��
	{
		this.stuName = stuName;
		this.fee = fee;
		this.hourlyPay = hourlyPay;
	}
	@Override
	public void setFee(double fee){
		this.fee = fee;
	}
	@Override
	public double getFee(){
		return fee;
	}
	@Override  //��д���㲢�����¹���
	public void calPay(int hour){     
		this.pay = this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
	
	void loanStatus(){ //�����Ƿ���Ҫ����
		double resultPay = this.pay * 12 - this.fee * 2;  //���㹤����ѧ�ѵĲ�ֵ
		if(resultPay < 3600){
			if(resultPay < 0){
				resultPay = (-1)*resultPay;
				System.out.println("You need a loam!");
				System.out.println("�����ȣ�" + (resultPay));
			}
		}
		else
			System.out.println("You pay is enough!");
	}
} 

//���塱Undergraduate�������������࣬������Student�����࣬��ʵ��ѧ���ӿ�
class Undergraduate extends Student implements StudentInf{
	//���췽��	
	public Undergraduate(String stuName,double fee){
		this.stuName = stuName;
		this.fee = fee;
	}
	@Override
	public void setFee(double fee){
		this.fee = fee;
	}
	@Override
	public double getFee(){
		return fee;
	}
}

//������
class Professor extends Teacher implements TeacherInf{
	//���췽��
	public Professor(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override  //��д���㲢�����¹���
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//��������
class adjProfessor extends Teacher implements TeacherInf{
	//���췽��
	public adjProfessor(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override   //��д���㲢�����¹���
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//��ʦ��
class Lecturer extends Teacher implements TeacherInf{
	//���췽��
	public Lecturer(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override  //��д���㲢�����¹���
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//������
class Assistant extends Teacher implements TeacherInf{
	//���췽��
	public Assistant(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override   //��д���㲢�����¹���
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//ѧУ��
class School{
	protected int hours;          //�ڿ�ʱ��
	protected double schoolBalance = 10000000;        //ѧУ�˻����
	protected int graduateNumber,undergraduateNumber;         //�о�������������������
	protected double graduatefee = 5000,undergraduatefee = 4000;  //һѧ�ڵ�ѧ�ѣ��о���5000��������4000
	public double getGraduatefee() {
		return graduatefee;
	}
	public void setGraduatefee(double graduatefee) {
		this.graduatefee = graduatefee;
	}
	public double getUndergraduatefee() {
		return undergraduatefee;
	}
	public void setUndergraduatefee(double undergraduatefee) {
		this.undergraduatefee = undergraduatefee;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getSchoolBalance() {
		return schoolBalance;
	}
	public void setSchoolBalance(double schoolBalance) {
		this.schoolBalance = schoolBalance;
	}
	public int getGraduateNumber() {
		return graduateNumber;
	}
	public void setGraduateNumber(int graduateNumber) {
		this.graduateNumber = graduateNumber;
	}
	public int getUndergraduateNumber() {
		return undergraduateNumber;
	}
	public void setUndergraduateNumber(int undergraduateNumber) {
		this.undergraduateNumber = undergraduateNumber;
	}
	//���췽��
	public School(){
		
	}
	
	//���㲢��ȡ��ѧ��ѧ��ѧ��
	public void getFees(int graduateNumber,int undergraduateNumber){
		double allfee = this.undergraduatefee*undergraduateNumber+this.graduatefee*graduateNumber;
		this.schoolBalance += allfee;
		System.out.println("��ȡѧ������ѧ��Ϊ��" + allfee);
	}
	
	//���㲢���Ž�ְ���¹���
	public void getPays(Professor p,adjProfessor a,Lecturer l,Assistant as){
		double allpay = p.getPay() + a.getPay() + l.getPay() + as.getPay();
		this.schoolBalance -= allpay;
		System.out.println("���Ž�ְ���ܵĹ���Ϊ��" + allpay);
	}
	
	//��ȡѧ�Ѻͷ��Ź��ʺ�ѧУ�˻����
	public void balance(){
		System.out.println("ѧУ�˻������Ϊ��" + this.schoolBalance);
	}
}