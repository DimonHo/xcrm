package com.dimon.xcrm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	public static String formatTimestamp(Date timestamp){
		DateFormat dateFormat; 
		dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINESE); 
		dateFormat.setLenient(false); 
		String timeDate = dateFormat.format(timestamp);//util类型 
		return timeDate;
	}
}
