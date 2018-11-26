package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 判断日期格式
	 * @param str
	 * @return
	 */
	public static boolean SimpleDateFormat(String str) {
		boolean convertSuccess=true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 try {
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			 format.parse(str);
		 } catch (ParseException e) {
		// e.printStackTrace();
		// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
		convertSuccess=false;
		} 
		return convertSuccess;
	}
	
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String gainDate(){
		String s=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		s=format.format(new Date());
		return s;
	}
	
	/**
     * 字符串日期格式的计算
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
        return Integer.parseInt(String.valueOf(between_days));     
    }  

}
