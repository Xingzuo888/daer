package atm;

import java.util.Scanner;

public class Machine {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Account account = new Account();
		double money;
		while(true){
			System.out.print("Enter an id: ");
			int id = input.nextInt();
			while(true){
				System.out.println();
				System.out.println("Main menu");
				System.out.println("1: check balance");
				System.out.println("2: withdraw");
				System.out.println("3: deposit");
				System.out.println("4: exit");
				System.out.print("Enter a choice: ");
				int num = input.nextInt();
				switch(num){
				case 1:
					account.check_balance(id);
					break;
				case 2:
					System.out.print("Enter an amount to withdraw: ");
					money = input.nextDouble();
					//account.withdraw(id, money);
					account.withdraw(id, money);;
					break;
				case 3:
					System.out.print("Enter an amount to deposit: ");
					money = input.nextDouble();
					//account.deposit(id, money);
					account.deposit(id, money);
					break;
				case 4:
					break;
				}
				if(num==4)
					break;
			}
			System.out.println();
		}
	}
}

class Account {

	 private int[] ID = new int[10];
	
	public Account(){
		for(int id = 0;id<10;id++)
			this.ID[id] = 100;
	}
	
	public int[] getID(){
		return ID;
	}
	
	
	public void check_balance(int id) {
		System.out.println("The balance is " + this.ID[id]);
	}
	
	public void withdraw(int id,double money){
		this.ID[id] -= money;
	}
	
	public void deposit(int id,double money){
		this.ID[id] += money;
    }
}