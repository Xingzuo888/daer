package Exercise;

import java.util.Scanner;

public class Test13_06 {

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.print("�������һ��Բ�İ뾶��");
		int radius1 = input.nextInt();
		System.out.print("������ڶ���Բ�İ뾶��");
		int radius2 = input.nextInt();
		
		//��������ComparableCircle����
		ComparableCircle c1 = new ComparableCircle(radius1);
		ComparableCircle c2 = new ComparableCircle(radius2);
		//��ӡComparableCircle�����нϴ���
		ComparableCircle c3 = (ComparableCircle) Max.max(c1, c2);
		System.out.println("The max circle's radius is " + c3.getRadius());
		System.out.println(c3);
	}
}

//������ΪComparableCircle���࣬�̳�Circle�࣬��ʵ��Comparable�ӿ�
class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
	
	public ComparableCircle(double radius){
		super(radius);
	}
	
	@Override
	public int compareTo(ComparableCircle o){
		if(this.getArea() < o.getArea())
			return -1;
		else if (this.getArea() == o.getArea())
			return 0;
		else
			return 1;
	}
	
	@Override
	public String toString(){
		return "[Circle] radius = " + this.getRadius();
	}
}

class Max{
	public static ComparableCircle max(ComparableCircle o1,ComparableCircle o2){
		if(o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}
}