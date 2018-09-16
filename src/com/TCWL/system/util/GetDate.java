package com.TCWL.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author WY
 *	将时间转化为字符串 yyyy-mm-dd
 */
public class GetDate {
	
	public static String getDate() {
		Date dateDate = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
	    String dateString = formatter.format(dateDate);  
	    return dateString;  
	}
	
/*	public static void main(String[] args) {
		System.out.println(getDate());
	}
*/
}
