import java.util.Scanner;

public class Polygonalarea {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of sides :");
    int num = input.nextInt();
    System.out.print("Enthe the side :");
    double side = input.nextDouble();
    area(num,side);
  }
  public static double area(int n ,double side) {
    double y = (n*side*side)/(4*Math.tan(Math.PI/n));
    System.out.println("The area of the polygon is "+ y);
    return 0;
  }
}