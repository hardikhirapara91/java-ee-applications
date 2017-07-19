package com.hardik.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Related Methods
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class DateUtil {

	/**
	 * Convert String to Date
	 * 
	 * @param paramDate
	 * @return Date Object
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String paramDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(paramDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * Convert Util Date to SQL Date
	 * 
	 * @param date
	 * @return sql date object
	 */
	public static java.sql.Date convertUtilDateToSQLDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
}
