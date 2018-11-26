package Exercise;

import java.util.Scanner;

public class Test13_09 {

	public static void main(String[] args){
		//��������Circle13_09����
		Circle13_09 obj1 = new Circle13_09();
		Circle13_09 obj2 = new Circle13_09();
		
		Scanner input = new Scanner(System.in);
		System.out.print("�������һ��Բ�İ뾶��");
		obj1.setRadius(input.nextInt());
		System.out.print("������ڶ���Բ�İ뾶��");
		
		obj2.setRadius(input.nextInt());
		
		//��ӡ���������radius
		System.out.println("����1 " + obj1.toString());
		System.out.println("����2 " + obj2.toString());
		
		//��equals�����ж����������Ƿ���ͬ��equals���ص���Booleanֵ
		System.out.println(obj1.equals(obj2));
		//��CompareTo�����ж��������󣬷��ص�������
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
