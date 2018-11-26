import java.util.Scanner;
public class Two_DimensionalArray{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of rows and columns in the array: ");
    int numberOfRows = input.nextInt();
    int numberOfColumns = input.nextInt();
    
    double[][] a = new double[numberOfRows][numberOfColumns];
    
    System.out.println("Enter the array: ");
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a[i].length; j++)
        a[i][j] = input.nextDouble();
    
    Location location = locateLargest(a);
    System.out.println("The location of the largest element is "
      + location.maxValue + " at ("
      + location.row + ", " + location.column + ")");
  }

  public static Location locateLargest(double[][] a){
    Location L = new Location();
    L.maxValue = a[0][0];
    for(int i=0;i<a.length;i++){
      for(int j=0;j<a[L.row].length;j++){
        if(L.maxValue<a[i][j]){
          L.maxValue = a[i][j];
          L.row = i;
          L.column = j;
        }
      }
    }
    return L;
  }
}

class Location{
  int row;
  int column;
 double maxValue;
}