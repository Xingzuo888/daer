public class ElectricFan{

  public static void main(String[] args){
    Fan fan1 = new Fan();
    fan1.setSpeed(Fan.FAST);
    fan1.setRadius(10);
    fan1.setColor("yellow");
    fan1.setOn(true);
    System.out.println(fan1.toString());

    System.out.println();

    Fan fan2 = new Fan();
    fan2.setSpeed(Fan.MEDIUM);
    fan2.setRadius(5);
    fan2.setColor("blue");
    fan2.setOn(false);
    System.out.println(fan2.toString());

  }
}

class Fan{

  public static int SLOW = 1;
  public static int MEDIUM = 2;
  public static int FAST = 3;

  private int speed = SLOW;
  private boolean on = false;
  private double radius = 5;
  String color = "blue";

  public Fan(){

  }

  public int getSpeed(){
    return speed;
  }
  public void setSpeed(int newSpeed){
    speed = newSpeed;
  }

  public double getRadius(){
    return radius;
  }
  public void setRadius(int newRadius){
    radius = newRadius;
  }

  public String getColor(){
    return color;
  }
  public void setColor(String newColor){
    color = newColor;
  }

  public boolean isOn(){
    return on;
  }
  public void setOn(boolean trueOrfalse){
    this.on = trueOrfalse;
  }
  
  //@Override
  public String toString(){
    return "speed  "+speed+"\n"
      +"radius  "+radius+"\n"
      +"color  "+color+"\n"
      +((on)?"fan is on":"fan is off");
  }
}