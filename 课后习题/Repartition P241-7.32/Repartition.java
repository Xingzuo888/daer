/**import java.util.Scanner;
import java.util.Arrays;
public class Repartition{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enthe list number: ");
    int num = input.nextInt();
    System.out.print("Enthe list : ");
    int[] list = new int[num];
    for(int i=0;i<num;i++)
      list[i] = input.nextInt();
    System.out.print("原列表为：");
    System.out.println(Arrays.toString(list));
    System.out.println("该支点位于新列表中的下标为：" + partition(list));
    System.out.print("新列表为：");
    System.out.println(Arrays.toString(list));
  }
  public static int partition(int[] list){
    int k=0,u,i,z;
    int[] list1 = new int[list.length];
    for(u=0;u<list.length;u++){
      if(list[u]<list[0]){
        list1[k]=list[u];
        k++;
      }
    }
    list1[k]=list[0];
    i=k;
    k++;
    for(u=0;u<list.length;u++){
      if(list[u]>list[0]){
        list1[k]=list[u];
        k++;
      }
    }
    System.arraycopy(list1,0,list,0,list1.length);
    return i;
  }
}*/






public class Repartition {
  public static void main (String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);

    // Enter values for list1
    System.out.print("Enter a list: ");
    int size = input.nextInt();
    int[] list = new int[size];    
    for (int i = 0; i < list.length; i++) 
      list[i] = input.nextInt();

    partition(list);
    
    System.out.print("After the partition, the list is ");
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }

  /** Partition the array list[first..last] */
  public static int partition(int[] list) {
  	int first = 0;
  	int last = list.length - 1;
    int pivot = list[first]; // Choose the first element as the pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low] <= pivot)
        low++;

      // Search backward from right
      while (low <= high && list[high] > pivot)
        high--;

      // Swap two elements in the list
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot)
      high--;

    // Swap pivot with list[high]
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }
}
