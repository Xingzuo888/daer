package jjjj;

public class Card {
	public String suit; 
	public String point;
	public Card(String suit,String point) {
		this.suit=suit; 
		this.point=point; 
		}
	@Override
	public String toString() { 
		return suit+point+" ";
		}

}
