package RAC;

import java.util.ArrayList;
import java.util.Scanner;

public class Max {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size n: ");
		int n = input.nextInt();
		
		int[][] array = new int[n][n];
		System.out.println("The random array is");
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				array[i][j] = (int)(Math.random()*2);
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
		//check row
		int rowSum = sumRow(array[0]);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(0);
		for(int i = 1;i < n;i++){
			if(rowSum < sumRow(array[i])){
				rowSum = sumRow(array[i]);
				list1.clear();
				list1.add(i);
			}
			else if(rowSum == sumRow(array[i])){
				list1.add(i);
			}
		}
		
		System.out.print("The largest row index: ");
		for(int i = 0;i < list1.size()-1;i++)
			System.out.print(list1.get(i) + ",");
		System.out.println(list1.get(list1.size()-1));
		
		//check column
		int columnSum = sumColumn(array,0);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(0);
		for(int i = 1;i < n;i++){
			if(columnSum < sumColumn(array,i)){
				columnSum = sumColumn(array,i);
				list2.clear();
				list2.add(i);
			}
			else if(columnSum == sumColumn(array,i)){
				list2.add(i);
			}
		}
		
		System.out.print("The largest column index: ");
		for(int i = 0;i < list2.size()-1;i++)
			System.out.print(list2.get(i) + ",");
		System.out.println(list2.get(list2.size()-1));
		
	}
	
	public static int sumRow(int array[]){
		int sum = 0;
		for(int i = 0;i < array.length;i++){
			sum += array[i];
		}
		return sum;
	}
	
	public static int sumColumn(int array[][],int n){
		int sum = 0;
		for(int i = 0;i<array.length;i++)
			sum += array[i][n];
		return sum;
	}
}
