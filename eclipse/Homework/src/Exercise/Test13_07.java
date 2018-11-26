package Exercise;

public class Test13_07 {
	public static void main(String[] args){
		//创建有五个GeometricObject对象的数组
		GeometricObject[] objects = { new Square(2),new Circle(5),new Square(5),new Rectangle(3,4),new Square(6) };
	
		for(int i=0;i<objects.length;i++){
			//打印面积
			System.out.println("Area is " + objects[i].getArea());
			//打印周长
			System.out.println("Perimeter is " + objects[i].getPerimeter());
			//判断是否可着色
			if(objects[i] instanceof Colorable){
				((Colorable)objects[i]).howToColor();
			}
		}
	}
}

//设计可着色接口Colorable
interface Colorable{
	void howToColor();
}

//创建名为Square类，继承GeometricObject，并实现Colorable接口
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