package java_program;

public class Tset {

	public static void main(String[] args) {
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
