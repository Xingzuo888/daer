package RAC;

import java.util.ArrayList;
import java.util.Scanner;

public class GD {
	public static void main(String[] args) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    removeDuplicate(list);
	}
	
	public static void removeDuplicate(ArrayList<Integer> list){
		System.out.print("Enter ten integers: ");
	    Scanner input = new Scanner(System.in);
	    int[] array = new int[10];
	    for(int i = 0; i<10;i++){
	    	array[i] = input.nextInt();
	    }
	    int j;
	    list.add(array[0]);
	    for(int i =1;i<10;i++){
	    	for(j = 0; j<list.size();j++){
	    		if(list.get(j) == array[i])
	    			break;
	    	}
	    	if(j == list.size())
	    		list.add(array[i]);
	    }
	    System.out.print("The distinct integers are: ");
	    for(int i = 0;i < list.size();i++)
	    	System.out.print(list.get(i) + " ");
	}
}
