package java_program;

public class Transcation {
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
