package Exercise;

import java.util.Scanner;

public class Test13_09 {

	public static void main(String[] args){
		//创建两个Circle13_09对象
		Circle13_09 obj1 = new Circle13_09();
		Circle13_09 obj2 = new Circle13_09();
		
		Scanner input = new Scanner(System.in);
		System.out.print("请输入第一个圆的半径：");
		obj1.setRadius(input.nextInt());
		System.out.print("请输入第二个圆的半径：");
		
		obj2.setRadius(input.nextInt());
		
		//打印两个对象的radius
		System.out.println("对象1 " + obj1.toString());
		System.out.println("对象2 " + obj2.toString());
		
		//用equals方法判断两个对象是否相同，equals返回的是Boolean值
		System.out.println(obj1.equals(obj2));
		//用CompareTo方法判断两个对象，返回的是整数
		System.out.println(obj1.compareTo(obj2));
	}
}

class Circle13_09 extends GeometricObject implements Comparable<Circle13_09> {

	private double radius;
	
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public double getPerimeter() {
		 return 2 * radius * Math.PI;
	}

	@Override
	public String toString(){
		return "radius = " + radius;
	}
	
	@Override
	public int compareTo(Circle13_09 obj){
		if(this.getArea() > obj.getArea())
			return 1;
		else if(this.getArea() < obj.getArea())
			return -1;
		else
			return 0;
	}
	
	public boolean equals(Object obj){
		return this.radius == ((Circle13_09)obj).radius;
	}
}
