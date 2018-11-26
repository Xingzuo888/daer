import java.util.Scanner;

public class Circle {
  public static void main(String[] args) {
    System.out.println("请输入两个圆的中心坐标和各自的半径");
    Scanner input = new Scanner(System.in);
    System.out.print("circle's center x1 , y1 , and radius1:");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double r1 = input.nextDouble();
    System.out.print("circle's center x2 , y2 , and radius2:");
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    double r2 = input.nextDouble();
    double cd = Math.sqrt(Math.pow(x2-x1 ,2)+Math.pow(y2-y1,2));
    if(cd <= Math.abs(r1-r2))
      System.out.println("circle2 is inside circle1");
    else if(cd <= r1+r2)
       System.out.println("circle2 overlaps circle1");
    else
       System.out.println("circle2 does not overlap circle1");
  }
}