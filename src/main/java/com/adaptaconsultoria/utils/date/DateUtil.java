package com.adaptaconsultoria.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String dateToString(Date date, String format) {
		try {
			SimpleDateFormat f = new SimpleDateFormat(format);
			return f.format( date );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String();
	}
}
