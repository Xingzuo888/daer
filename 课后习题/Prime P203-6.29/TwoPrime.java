
public class TwoPrime {
  public static void main(String[] args) {
    for(int i = 3;i<1000;i+=2){
      twoprime(i,i+2);
    }
  }
  public static void twoprime(int x,int y){
    int z=0,v=0;
    for(int k=1;k<=x;k++){
      if(x%k==0)
        z++;
    }
    for(int l=1;l<=y;l++){
      if(y%l==0)
        v++;
    }
    if(z==2&&v==2)
      System.out.println("(" + x + "," + y + ")");
  }
}