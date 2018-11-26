package 高校财务应用程序;

public class 高校财务应用程序 {
		public static void main(String[] args){
			Professor p = new Professor("jj",5000,50);         //创建教授对象，并写入信息
			adjProfessor a = new adjProfessor("tt",3000,40);   //创建副教授对象，并写入信息
			Lecturer l = new Lecturer("qq",2000,30);           //创建讲师对象，并写入信息
			Assistant as = new Assistant("ww",1500,20);        //创建助教对象，并写入信息
			p.calPay(30);a.calPay(40);l.calPay(50);as.calPay(60);  //输入月课时量
			//打印教师的月工资
			System.out.println("教授" + p.teaName + "的月工资为：" + p.getPay());
			System.out.println("副教授" + a.teaName + "的月工资为：" + a.getPay());
			System.out.println("讲师" + l.teaName + "的月工资为：" + l.getPay());
			System.out.println("助教" + as.teaName + "的月工资为：" + as.getPay());
			//创建学校对象
			School s = new School();
			s.getFees(20, 100);      //计算总的学生学费
			s.balance();             //打印学校账户余额
			s.getPays(p,a,l,as);     //计算发放教职工总的工资
			s.balance();             //打印学校账户余额
			
			Graduate g = new Graduate("xx",5000,20);   //创建研究生对象
			System.out.println("对于" + g.stuName + "研究生：");
			g.calPay(30);          //  计算月参与助教的酬劳
			g.loanStatus();        // 打印该研究生是否需要贷款，若需要，则打印贷款额度
		}
	
}

abstract class Student {
	String stuName;    //学生姓名
	double fee;     //每学期学费
}

abstract class Teacher {
	String teaName;    //教师姓名
	double basePay;    //每月固定工资
	double  hourlyPay;          //课时费
	double  pay;             //每月工资
}

interface StudentInf {
	void setFee(double fee);     //设置每学期学费
	double getFee();             //获取每学期学费
}

interface TeacherInf {
	void calPay(int hour);      //计算并设置月工资
	double getPay();             //获取月工资
}

class Graduate extends Student implements StudentInf,TeacherInf{
    double hourlyPay;           //每小时酬劳
	double pay;             //每月酬劳
	public Graduate( String stuName, double fee, double hourlyPay)    //构造函数
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
	@Override  //重写计算并设置月工资
	public void calPay(int hour){     
		this.pay = this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
	
	void loanStatus(){ //评估是否需要贷款
		double resultPay = this.pay * 12 - this.fee * 2;  //计算工资与学费的差值
		if(resultPay < 3600){
			if(resultPay < 0){
				resultPay = (-1)*resultPay;
				System.out.println("You need a loam!");
				System.out.println("贷款额度：" + (resultPay));
			}
		}
		else
			System.out.println("You pay is enough!");
	}
} 

//定义”Undergraduate（本科生）”类，派生自Student抽象类，并实现学生接口
class Undergraduate extends Student implements StudentInf{
	//构造方法	
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

//教授类
class Professor extends Teacher implements TeacherInf{
	//构造方法
	public Professor(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override  //重写计算并设置月工资
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//副教授类
class adjProfessor extends Teacher implements TeacherInf{
	//构造方法
	public adjProfessor(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override   //重写计算并设置月工资
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//讲师类
class Lecturer extends Teacher implements TeacherInf{
	//构造方法
	public Lecturer(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override  //重写计算并设置月工资
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//助教类
class Assistant extends Teacher implements TeacherInf{
	//构造方法
	public Assistant(String teaName,double basePay,double hourlyPay){
		this.teaName = teaName;
		this.basePay = basePay;
		this.hourlyPay = hourlyPay;
	}
	@Override   //重写计算并设置月工资
	public void calPay(int hour){
		this.pay = this.basePay + this.hourlyPay * hour;
	}
	@Override
	public double getPay(){
		return pay;
	}
}

//学校类
class School{
	protected int hours;          //授课时间
	protected double schoolBalance = 10000000;        //学校账户余额
	protected int graduateNumber,undergraduateNumber;         //研究生人数、本科生人数
	protected double graduatefee = 5000,undergraduatefee = 4000;  //一学期的学费，研究生5000，本科生4000
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
	//构造方法
	public School(){
		
	}
	
	//计算并收取本学期学生学费
	public void getFees(int graduateNumber,int undergraduateNumber){
		double allfee = this.undergraduatefee*undergraduateNumber+this.graduatefee*graduateNumber;
		this.schoolBalance += allfee;
		System.out.println("收取学生的总学费为：" + allfee);
	}
	
	//计算并发放教职工月工资
	public void getPays(Professor p,adjProfessor a,Lecturer l,Assistant as){
		double allpay = p.getPay() + a.getPay() + l.getPay() + as.getPay();
		this.schoolBalance -= allpay;
		System.out.println("发放教职工总的工资为：" + allpay);
	}
	
	//收取学费和发放工资后学校账户余额
	public void balance(){
		System.out.println("学校账户的余额为：" + this.schoolBalance);
	}
}