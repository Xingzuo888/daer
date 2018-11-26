
public class Craps {
  public static void main(String[] args){
    int num1 = (int)(1+(Math.random()*5));
    int num2 = (int)(1+(Math.random()*5));
    if(num1+num2==2||num1+num2==3||num1+num2==12){
      System.out.println("You rolled " + num1 + "+" + num2 + "= " + (num1+num2));
      System.out.println("You lose ");
    }
    else if(num1+num2==7||num1+num2==11){
      System.out.println("You rolled " + num1 + "+" + num2 + "= " + (num1+num2));
      System.out.println("You win ");
    }
    else{
      System.out.println("You rolled " + num1 + "+" + num2 + "= " + (num1+num2));
      System.out.println("point is " +  (num1+num2));
      crap(num1+num2);  
    }
  }
  public static void crap(int i){
    while(1<i){
      int num1 = (int)(1+(Math.random()*5));
      int num2 = (int)(1+(Math.random()*5));
      if(num1+num2==7){
        System.out.println("You rolled " + num1 + "+" + num2 + "= " + (num1+num2));
        System.out.println("You lose ");
        break;
      }
      if(num1+num2==i){
        System.out.println("You rolled " + num1 + "+" + num2 + "= " + (num1+num2));
        System.out.println("You win ");
        break;
      }
    }
  }
}