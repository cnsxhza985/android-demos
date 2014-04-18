package com.cnsxhza985.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对时间操作的工具集合
 * 
 * @author wangfan
 * 
 */
public class TimeTools {
	
	public static final String FORMAT_24H_Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_12H_Y_M_D_H_M_S = "yyyy-MM-dd hh:mm:ss";

	/**
	 * Date类型转换为String类型
	 * formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 * 
	 * @param data			Date类型的时间
	 * @param formatType	转换的格式
	 * @return
	 */
	public static String dateToString(Date data, String formatType) {
		return new SimpleDateFormat(formatType).format(data);
	}

	/**
	 * long类型转换为String类型
	 * @param currentTime	要转换的long类型的时间
	 * @param formatType	要转换的string类型的时间格式
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static String longToString(long currentTime, String formatType)
			throws ParseException, java.text.ParseException {
		Date date = longToDate(currentTime, formatType); // long类型转成Date类型
		String strTime = dateToString(date, formatType); // date类型转成String
		return strTime;
	}

	/**
	 * string类型转换为date类型，strTime的时间格式必须要与formatType的时间格式相同
	 * @param strTime		要转换的string类型的时间
	 * @param formatType	要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static Date stringToDate(String strTime, String formatType)
			throws ParseException, java.text.ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(strTime);
		return date;
	}

	/**
	 * long转换为Date类型
	 * @param currentTime	要转换的long类型的时间
	 * @param formatType	要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static Date longToDate(long currentTime, String formatType)
			throws ParseException, java.text.ParseException {
		Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
		String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
		Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
		return date;
	}

	/**
	 * string类型转换为long类型,strTime的时间格式和formatType的时间格式必须相同
	 * @param strTime		要转换的String类型的时间
	 * @param formatType	时间格式
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static long stringToLong(String strTime, String formatType)
			throws ParseException, java.text.ParseException {
		Date date = stringToDate(strTime, formatType); // String类型转成date类型
		if (date == null) {
			return 0;
		} else {
			long currentTime = dateToLong(date); // date类型转成long类型
			return currentTime;
		}
	}

	/**
	 * date类型转换为long类型
	 * @param date	要转换的date类型的时间
	 * @return
	 */
	public static long dateToLong(Date date) {
		return date.getTime();
	}

	/**
	 * int类型的时间转换为String类型的时间
	 * @param number
	 * @param formatType
	 * @return
	 */
	public static String numToDate(int number, String formatType) {
		Date date = new Date(number);
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}
}
