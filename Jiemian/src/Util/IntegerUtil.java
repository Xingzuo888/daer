package Util;

import java.util.regex.Pattern;

public class IntegerUtil {

	/**
	 * �ж��Ƿ�������
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		Pattern pattern=Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}
}
