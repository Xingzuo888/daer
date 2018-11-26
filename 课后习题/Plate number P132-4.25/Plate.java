
public class Plate {
  public static void main(String[] args) {
    int a=1;
    while(a<6) {
      char number1 =(char)( 'A' + (Math.random()*26));
      char number2 =(char)( 'A' + (Math.random()*26));
      char number3 =(char)( 'A' + (Math.random()*26));
      int number4 = (int)(Math.random()*10);
      int number5 = (int)(Math.random()*10);
      int number6 = (int)(Math.random()*10);
      int number7 = (int)(Math.random()*10);
      System.out.println(" Plate number" + a + ": " + number1 + number2 + number3 + number4 + number5 + number6 + number7);
      a++;
    }
  }
}