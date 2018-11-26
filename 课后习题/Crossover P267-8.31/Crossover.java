import java.util.Scanner;

public class Crossover{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enthe x1,y1,x2,y2,x3,y3,x4,y4: ");
    double[][] points = new double[4][2];
    for(int i=0;i<4;i++)
      for(int j=0;j<2;j++)
        points[i][j] = input.nextDouble();
    double[] result = getIntersectingPoint(points);
    if(result == null)
      System.out.println("The two lines are parallel");

    else
      System.out.println("The intersecting point is at (" + result[0] + "," + result[1] + ")");
  }
  
  public static double[] getIntersectingPoint(double[][] P){
    double x1 = P[0][0];
    double y1 = P[0][1];
    double x2 = P[1][0];
    double y2 = P[1][1];
    double x3 = P[2][0];
    double y3 = P[2][1];
    double x4 = P[3][0];
    double y4 = P[3][1];

    double[][] a = new double[2][2];
    double[] b = new double[2];

    a[0][0] = y1-y2;
    a[0][1] = x1-x2;
    a[1][0] = y3-y4;
    a[1][1] = x3-x4;
    b[0] = (y1-y2)*x1 - (x1-x2)*y1;
    b[1] = (y3-y4)*x3 - (x3-x4)*y3;

    double datA = a[0][0]*a[1][1]-a[1][0]*a[0][1];
    if(datA == 0)
      return null;
    else{
      double[] result = new double[2];
      result[0] = (b[0]*a[1][1] - b[1]*a[0][1])/datA;
      result[1] = (b[1]*a[0][0] - b[0]*a[1][0])/datA;
      return result;
    }
  }
}