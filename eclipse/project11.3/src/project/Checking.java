package project;

public class Checking extends Account {

	protected double overdraftLimit = 5000;
	
	@Override
	public String toString(){
		return "Checking";
	}
}
