package Exercise;

public class Test13_07 {
	public static void main(String[] args){
		//���������GeometricObject���������
		GeometricObject[] objects = { new Square(2),new Circle(5),new Square(5),new Rectangle(3,4),new Square(6) };
	
		for(int i=0;i<objects.length;i++){
			//��ӡ���
			System.out.println("Area is " + objects[i].getArea());
			//��ӡ�ܳ�
			System.out.println("Perimeter is " + objects[i].getPerimeter());
			//�ж��Ƿ����ɫ
			if(objects[i] instanceof Colorable){
				((Colorable)objects[i]).howToColor();
			}
		}
	}
}

//��ƿ���ɫ�ӿ�Colorable
interface Colorable{
	void howToColor();
}

//������ΪSquare�࣬�̳�GeometricObject����ʵ��Colorable�ӿ�
class Square extends GeometricObject implements Colorable{
	private double side;
	
	public Square(double side){
		this.side = side;
	}
	
	@Override
	public void howToColor(){
		System.out.println("Color all four sides");
	}
	
	@Override
	public double getArea(){
		return side*side;
	}
	
	@Override
	public double getPerimeter(){
		return side*4;
	}
}