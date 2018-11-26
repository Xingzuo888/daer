import java.util.Scanner;

public class Position {
  public static void main(String[] args) {
    //System.out.println("请输入三个点P0,P1,P2的坐标");
    Scanner input = new Scanner(System.in);
    System.out.print("three points for p0,p1,p2:");
    double x0 = input.nextDouble();
    double y0 = input.nextDouble();
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    double answer = (x1-x0)*(y2-y0)-(x2-x0)*(y1-y0);
    if(answer > 0)
      System.out.println("(" + x2 + "," + y2 + ")" + "is on the left side of the line from" + "(" + x0 +"," + y0 + ") to (" + x1 + "," +  y1 + ")");
    else if(answer == 0)
      System.out.println("(" + x2 + "," + y2 + ")" + "is on the line from" + "(" + x0 +"," + y0 + ") to (" + x1 + "," +  y1 + ")");
    else if(answer < 0)
      System.out.println("(" + x2 + "," + y2 + ")" + "is on the right side of the line from" + "(" + x0 +"," + y0 + ") to (" + x1 + "," +  y1 + ")");
  }
}