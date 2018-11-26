package project;

public class Saving extends Account {

	protected double overdraftLimit = 5000;
	
	@Override
	public String toString(){
		return "Saving";
	}
}
