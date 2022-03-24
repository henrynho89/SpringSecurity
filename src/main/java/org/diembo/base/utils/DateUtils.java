package org.diembo.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;


public class DateUtils {
	public static java.sql.Date convertJavaUtilDateToSqlDate(
			java.util.Date pDate) {
		if (pDate == null)
			return null;
		return new java.sql.Date(pDate.getTime());
	}

	public static String getddMMyyyy2(Date date, String sep) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd"+sep+"MM"+sep+"yyyy");
		String result = formatter.format(date);
		return result;
	}

	public static String getddMMyy(Date date, String sep) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd"+sep+"MM"+sep+"yy");
		String result = formatter.format(date);
		return result;
	}

	public static String getddMMyyyy(Date date, String sep) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String day = lpad(cal.get(Calendar.DAY_OF_MONTH) + "", 2, '0');
		String month = lpad((cal.get(Calendar.MONTH) + 1) + "", 2, '0');
		String year = lpad(cal.get(Calendar.YEAR) + "", 4, '0');

		return day + sep + month + sep + year;
	}

	public static String getyyyyMMdd(Date date, String sep) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy"+sep+"MM"+sep+"dd");
		String result = formatter.format(date);
		return result;
	}

	public static String getddMMyyyyHHmmss(Date date, String sep) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		String second = lpad(cal.get(Calendar.SECOND) + "", 2, '0');
		String minute = lpad(cal.get(Calendar.MINUTE) + "", 2, '0');
		String hour = lpad(cal.get(Calendar.HOUR_OF_DAY) + "", 2, '0');

		String day = lpad(cal.get(Calendar.DAY_OF_MONTH) + "", 2, '0');
		String month = lpad((cal.get(Calendar.MONTH) + 1) + "", 2, '0');
		String year = lpad(cal.get(Calendar.YEAR) + "", 4, '0');

		return day + sep + month + sep + year + sep + hour + sep + minute + sep
				+ second;
	}
	
	public static String getddMMyyyyHHmm(Date date, String sep) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		String minute = lpad(cal.get(Calendar.MINUTE) + "", 2, '0');
		String hour = lpad(cal.get(Calendar.HOUR_OF_DAY) + "", 2, '0');

		String day = lpad(cal.get(Calendar.DAY_OF_MONTH) + "", 2, '0');
		String month = lpad((cal.get(Calendar.MONTH) + 1) + "", 2, '0');
		String year = lpad(cal.get(Calendar.YEAR) + "", 4, '0');

		return day + sep + month + sep + year + "  " + hour + ":" + minute;
	}
	
	public static String getHHmm(Date date, String sep) {
		if (date ==null) {
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		String minute = lpad(cal.get(Calendar.MINUTE) + "", 2, '0');
		String hour = lpad(cal.get(Calendar.HOUR_OF_DAY) + "", 2, '0');

		return hour + sep + minute;
	}

	// Date now=new Date();
	// DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
	// DateTrx = df.format(now);
	//
	// System.out.println("Date Transaction: "+DateTrx);

	public static String getDDMM(Date date, String sep) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String day = lpad(cal.get(Calendar.DAY_OF_MONTH) + "", 2, '0');
		String month = lpad((cal.get(Calendar.MONTH) + 1) + "", 2, '0');

		return day + sep + month;
	}


	//--------------------------------------------------------------------
	public static Date toDate(String dateAndFormat) {
		String[] parts = dateAndFormat.split("\\s*:\\s*");
		String date = parts[0];
		String format = parts.length >= 2 ? parts[1] : "yyyyMMdd" ;
		return toDate ( date, format ) ;
	}

	//--------------------------------------------------------------------
	public static Date toDate(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			throw new RuntimeException("Date: '" + date + "', Format: '"
					+ format + "'");
		}
	}

	/**
	 * @deprecated Use {@link StringUtils#lpad(String, int, char)} instead.
	 */
	@Deprecated
	public static String lpad(String data, int length, char pad) {
		return StringUtils.lpad(data, length, pad);
	}

	/**
	 * @deprecated Use {@link StringUtils#lpad(String, int)} instead.
	 */
	@Deprecated
	public static String lpad(String data, int length) {
		return StringUtils.lpad(data, length, ' ');
	}

	/**
	 * @deprecated Use {@link StringUtils#rpad(String, int, char)} instead.
	 */
	@Deprecated
	public static String rpad(String data, int length, char pad) {
		return StringUtils.rpad(data, length, pad);
	}

	/**
	 * @deprecated Use {@link StringUtils#rpad(String, int)} instead.
	 */
	@Deprecated
	public static String rpad(String data, int length) {
		return StringUtils.rpad(data, length, ' ');
	}

	/**
	 * @deprecated Use {@link StringUtils#formatDoubleValue_2(double, int)} instead.
	 */
	@Deprecated
	public static String formatDoubleValue_2(double value, int decimalPlaces) {
		return StringUtils.formatDoubleValue_2(value, decimalPlaces);
	}

	/**
	 * @deprecated Use {@link StringUtils#getStrings(byte[] , byte)} instead.
	 */
	@Deprecated
	@SuppressWarnings("rawtypes")
	public static Vector getStrings(byte[] message, byte sep) {
		return StringUtils.getStrings(message, sep);
	}

	/**
	 * @deprecated Use {@link StringUtils#getByteArrays(byte[] , byte)} instead.
	 */
	@Deprecated
	@SuppressWarnings("rawtypes")
	public static Vector getByteArrays(byte[] message, byte sep) {
		return StringUtils.getByteArrays(message, sep);
	}

	/**
	 * @deprecated Use {@link StringUtils#split(String , char)} instead.
	 */
	@Deprecated
	public static String[] split(String original, char separator) {
		return StringUtils.split(original, separator);
	}

	
	// -------------------------------------------------------------------------------------- //
	// -------------------------------------------------------------------------------------- //
	public static Date addDays(Date date, int days) {
		 Calendar cal = Calendar.getInstance();
	     cal.setTime(date);
	     cal.add(Calendar.DATE, days); //minus number would decrement the days
	     return cal.getTime();
	}
	
	// -------------------------------------------------------------------------------------- //
	// -------------------------------------------------------------------------------------- //
	
	public static Date addHours(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}
	
	public static Date getNextWeek(Date date) {
		// set the date
		Calendar cal = Calendar.getInstance(Locale.FRENCH);
		cal.setTime(date);

		// "calculate" the start date of the week
		Calendar first = (Calendar) cal.clone();
		first.add(Calendar.DAY_OF_WEEK,first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK));

		// and add seven days to the end date
		Calendar last = (Calendar) first.clone();
		last.add(Calendar.DAY_OF_YEAR, 7);

		return last.getTime();
	}
	
	// -------------------------------------------------- //
	public static Date getNextFortnight(Date date) {
		// set the date
		Calendar cal = Calendar.getInstance(Locale.FRENCH);
		cal.setTime((Date) date.clone());
		
		if ( cal.get(Calendar.DAY_OF_MONTH) < 16 ){
			cal.set(Calendar.DAY_OF_MONTH, 16);
		}
		else{
			cal.setTime(getNextMonth(date));
		}

		return cal.getTime();
	}
	
	// -------------------------------------------------- //
	
	public static Date getNextMonth(Date date) {
		Date dueDate = (Date) date.clone();
		
		// set the date
		Calendar cal = Calendar.getInstance();
		cal.setTime(dueDate);

		// add a month to the current date
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, cal.getMinimum(Calendar.DATE));
		
		return cal.getTime();
	}
	
	// -------------------------------------------------- //
	public static Date resetTimeTo (Date date , int hour , int minutes, int seconds, int milliseconds) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		// Reset Hour, Minute, Seconds to 0
		cal.set(Calendar.HOUR_OF_DAY		, hour			);
		cal.set(Calendar.MINUTE				, minutes		);
		cal.set(Calendar.SECOND				, seconds		);
		cal.set(Calendar.MILLISECOND		, milliseconds	);
		
		
		// Return Date
		return cal.getTime(); 
	}
	
	// -------------------------------------------------- //
	
	public static Date resetTime (Date date) {
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		// Return Date
		return resetTimeTo(cal.getTime(), 0, 0, 0, 0);
	}
	
/*
 	public static Date setTimeToEndDay(Date date) {
		if (date == null) return null;
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime( date );
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
 */

}
