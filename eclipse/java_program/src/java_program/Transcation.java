package java_program;

public class Transcation {
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
