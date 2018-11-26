/**import java.util.Scanner;

public class BeanMachine{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enthe the number of balls to drop: ");
    int ball = input.nextInt();
    System.out.print("Enthe the number of balls to slots in the bean machine: ");
    int slot = input.nextInt();
    int[] slots = new int[slot+1];
    int[][] add = new int[ball][slot+1];
    System.out.println();
    System.out.println();
    move(ball,slot,slots,add);
    System.out.println();
    System.out.println();
    display(ball,slot,add);
  }

  public static void move(int ball,int slot,int[] slots,int[][] add){
    for(int i=1;i<=ball;i++){
      int k = 0;
      int z=ball;    
      for(int j=0;j<slot-1;j++){
        int direction = (int)(Math.random()*2);
        if(direction == 0)
          System.out.print("L");
        if(direction == 1){
          System.out.print("R");
          k++;
        }
      }
      if(k==0)
        k++;
      System.out.println();
      slots[k] += 1;
      if(add[z][k]==1){
        z = z-slots[k];
        add[z][k] = 1;
      }
      else
        add[z][k] = 1;
    }
  }

  public static void display(int ball,int slot,int[][] add){
    for(int i=0; i<ball;i++){
      for(int j=1;j<slot+1;j++){
        if(add[i][j]==1)
          System.out.print("O");
        else
          System.out.print(" ");
      }
      System.out.println();
    }
  }
}*/







import java.util.Scanner;

public class BeanMachine {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of balls to drop: ");
    int numberOfBalls = input.nextInt();
    
    System.out.print("Enter the number of slots: ");
    int numberOfSlots = input.nextInt();
    
    int[] slots = new int[numberOfSlots];
    
    for (int i = 0; i < numberOfBalls; i++) {
      slots[onePath(numberOfSlots)]++;
    }

    printHistogram(slots);
  }
  
  /** Return the slot position of the ball for a path and also print 
   * the path */
  public static int onePath(int numberOfSlots) {
    int position = 0;
    
    for (int i = 0; i < numberOfSlots - 1; i++)
      if (Math.random() < 0.5) {
        System.out.print("L");
      }
      else {
        System.out.print("R");
        position++;        
      }
    
    System.out.println();
    
    return position;
  }
  
  /** Print the histogram for the slots */
  public static void printHistogram(int[] slots) {
    int maxSlotHeight = max(slots);
    
    for (int h = maxSlotHeight; h > 0; h--) {
      for (int i = 0; i < slots.length; i++)
        if (slots[i] < h)
          System.out.print(" "); // Print nothing
        else
          System.out.print("O"); // Print a ball       
      
      System.out.println();
    }
  }
  
  /** Get the max element in slots */
  public static int max(int[] slots) {
    int result = slots[0];
    
    for (int i = 1; i < slots.length; i++) {
      if (result < slots[i])
        result = slots[i];
    }
    
    return result;
  }
}
