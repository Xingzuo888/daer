package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * �ж����ڸ�ʽ
	 * @param str
	 * @return
	 */
	public static boolean SimpleDateFormat(String str) {
		boolean convertSuccess=true;
		// ָ�����ڸ�ʽΪ��λ��/��λ�·�/��λ���ڣ�ע��yyyy/MM/dd���ִ�Сд��
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 try {
		// ����lenientΪfalse. ����SimpleDateFormat��ȽϿ��ɵ���֤���ڣ�����2007/02/29�ᱻ���ܣ���ת����2007/03/01
			 format.parse(str);
		 } catch (ParseException e) {
		// e.printStackTrace();
		// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
		convertSuccess=false;
		} 
		return convertSuccess;
	}
	
	/**
	 * ��ȡ��ǰ����
	 * @return
	 */
	public static String gainDate(){
		String s=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		s=format.format(new Date());
		return s;
	}
	
	/**
     * �ַ������ڸ�ʽ�ļ���
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
