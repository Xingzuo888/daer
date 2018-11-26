import java.util.Scanner;
public class Algebra{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();

    QuadraticEquation equation = new QuadraticEquation(a,b,c);
    double discriminant = equation.getDiscriminant();

    System.out.println("getDiscriminant  : " + discriminant);
    if(discriminant > 0)
      System.out.println("getRoot1 : " + equation.getRoot1() + "\n" +"getRoot2 : " + equation.getRoot2());
    else if(discriminant == 0)
      System.out.println("getRoot : " + equation.getRoot1());
    else
      System.out.println("The equation has no roots");
  }
}

class QuadraticEquation{

  private double a;
  private double b;
  private double c;

  public QuadraticEquation(double newA,double newB,double newC){
    a = newA;
    b = newB;
    c = newC;
  }

  public double getA(){
    return a;
  }

  public double getB(){
    return b;
  }
 
  public double getC(){
    return c;
  }
 
  public double getDiscriminant(){
    return b * b - 4 * a * c;
  }

  public double getRoot1(){
    if((b * b - 4 * a * c)>=0)
      return ((-b) + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    else
      return 0;
  }
  public double getRoot2(){
    if((b * b - 4 * a * c)>=0)
      return ((-b) - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    else
      return 0;
  }
}