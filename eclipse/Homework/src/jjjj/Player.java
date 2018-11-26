package jjjj;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public Integer id; 
	public String name;
	public List<Card> cards;
	public Player(int id,String name) { 
		this.id=id; this.name=name; 
		this.cards=new ArrayList<Card>();
		} 
	@Override
	public String toString() { 
		return name; 
		}

}
