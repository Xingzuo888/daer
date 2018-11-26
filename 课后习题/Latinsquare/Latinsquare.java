import java.util.Scanner;

public class Latinsquare{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number n: ");
    int n = input.nextInt();
    char[][] letter = new char[n][n];
    //input letter
    System.out.println("Enter "+n+"rows of letters separated by spaces:");
    for(int i=0;i<n;i++)
      for(int j=0;j<n;j++){
        letter[i][j] = input.nextChar();
      }
    //cheak letter
     for(int i=0;i<n;i++)
       for(int j=0;j<n;j++)
         if(letter[i][j]<'A' || letter[i][j]>('A'+n-1)){
           System.out.println("Wrong input: the letter must be from A to " + ('A'+n-1));
           System.exit(0);
          }

    getLatinletter(letter,n);
  }
  
  public static int getLatinletter(int[][] L,int n){
    for(int row=0;row<n;row++){
      for(int i=0;i<n;i++){
        int temp = L[i][0];
        for(int j=i+1;j<n;j++){
          if(temp==L[i][j]){
            System.out.println("The input array not a Latin square");
            return 0;
          }
        }
      }
    }
    for(int list=0;list<n;list++){
      for(int i=0;i<n;i++){
        int temp = L[0][i];
        for(int j=i+1;j<n;j++){
          if(temp==L[j][i]){
            System.out.println("The input array not a Latin square");
            return 0;
          }
        }
      }
    }
    System.out.println("The input array is a Latin square");
    return 0;
  }
}