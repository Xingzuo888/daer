package Exercise;

import java.util.Scanner;

public class Test13_05 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("请输入第一个圆的半径：");
		int radius1 = input.nextInt();
		System.out.print("请输入第二个圆的半径：");
		int radius2 = input.nextInt();
		
		//创建两个Circle1对象
		Circle1 c1 = new Circle1(radius1);
		Circle1 c2 = new Circle1(radius2);
		
		//打印Circle1对象中的较大者
		Circle1 c = (Circle1) GeometricObject13_05.max(c1, c2);
		System.out.println("The max circle's radius is " + c.getRadius());
		System.out.println(c);
	}
}

abstract class GeometricObject13_05 implements Comparable<GeometricObject13_05> {
	protected String color;
	
	//无参构造方法
	protected GeometricObject13_05(){
		color = "white";
	}
	
	//带有颜色的构造方法
	protected GeometricObject13_05(String color){
		this.color = color;
	}
	
	//返回颜色
	public String getColor(){
		return color;
	}
	
	//修改颜色
	public void setColor(String color){
		this.color = color;
	}
	
	//定义一个面积的抽象方法
	public abstract double getArea();
	
	//定义一个周长的抽象方法
	public abstract double getPerimeter();
	
	//比较对象的大小
	public int compareTo(GeometricObject13_05 o){
		if(getArea() < o.getArea())
			return -1;
		else if(getArea() == o.getArea())
			return 0;
		else
			return 1;
	}
	
	//返回GeometricObject13_05对象中较大者
	public static GeometricObject13_05 max(GeometricObject13_05 o1,GeometricObject13_05 o2){
		if(o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}
}

class Circle1 extends GeometricObject13_05 {

	protected double radius;
	
	public Circle1(){
		this.radius = 1.0;
		this.color = "white";
	}
	
	public Circle1(double radius){
		super("white");
		this.radius = radius;
	}
	
	public Circle1(double radius,String color){
		this.radius = radius;
		setColor(color);
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius*radius*Math.PI;
	}

	public double getPerimeter() {
		return 2*radius*Math.PI;
	}
	
	public boolean equals(Circle1 circle){
		return this.radius == circle.getRadius();
	}
	
	@Override
	public String toString(){
		return "[Circle] radius = " + radius;
	}
	
	@Override
	public int compareTo(GeometricObject13_05 o){
		if(getRadius() > ((Circle1) o).getRadius())
			return 1;
		else if(getRadius() == ((Circle1) o).getRadius())
			return 0;
		else
			return -1;
	}
}
