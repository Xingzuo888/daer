package Util;

public class DoubleUtil {

	public static boolean isEmpty(String str){
		
		try
		   {
		      Double.parseDouble(str);
		      return true;
		   }
		   catch(NumberFormatException ex){
			   return false;
		   }
		   
		
	}
}
