package org.diembo.base.utils.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.diembo.base.utils.DateResetManager;
import org.diembo.base.utils.DateUtils;
import org.springframework.stereotype.Component;


@Component
public class DateResetManagerImpl implements DateResetManager {


		
	public static DateFormat		yyyyMMdd				= new SimpleDateFormat("yyyyMMdd"); 
	

	public ResetIndicators reset(Date lastTransactionDate,	Date currentTransactionDate , int specificDayOfTheWeek) {
		
		ResetIndicators resetIndicators = new ResetIndicators(); 
		
		// Is it the first transaction ?? 
		
		resetIndicators.setResetDaily	(false);
		resetIndicators.setResetWeekly	(false);
		resetIndicators.setResetMonthly	(false);
		resetIndicators.setResetYearly	(false);
		
		if ( lastTransactionDate == null) {
			return resetIndicators; 
		}
		
		// All indicators should be marked as false
		
		if ( currentTransactionDate == null) {
			throw new RuntimeException("The current transaction date is null!");
		}
		
		if ( currentTransactionDate.compareTo(lastTransactionDate) < 0 ) {
			throw new RuntimeException("The last transaction has been executed after this transaction!");
		}
		
		// Accepted Values for specificDayOfTheWeek : [1-7]
		// SUNDAY = 1, MONDAY = 2  .... SATURDAY =7
		
		if ( specificDayOfTheWeek > 7 ||  specificDayOfTheWeek <= 0 ) {
			throw new RuntimeException("Invalid specificDayOfTheWeek '" + "'. Should be in range ");
		}
		
		Calendar cLastTransaction = Calendar.getInstance();
		cLastTransaction.setTime(DateUtils.resetTime(lastTransactionDate));

		Calendar cCurrentTransaction = Calendar.getInstance();
		cCurrentTransaction.setTime(DateUtils.resetTime(currentTransactionDate));

		// Year Difference between the 2 dates 
		if ( cLastTransaction.get(Calendar.YEAR) < cCurrentTransaction.get(Calendar.YEAR)) {
			resetIndicators.setResetDaily	(true);
			resetIndicators.setResetMonthly	(true);
			resetIndicators.setResetYearly	(true);
			resetIndicators.setResetWeekly(!sameWeek(lastTransactionDate, currentTransactionDate, specificDayOfTheWeek));
			return resetIndicators; 
		}
		
		// Month Difference between the 2 dates
		if ( cLastTransaction.get(Calendar.MONTH) < cCurrentTransaction.get(Calendar.MONTH)) {
			resetIndicators.setResetDaily	(true);
			resetIndicators.setResetMonthly	(true);
			
			resetIndicators.setResetWeekly(!sameWeek(lastTransactionDate, currentTransactionDate, specificDayOfTheWeek));
			return resetIndicators; 
		}
		
		resetIndicators.setResetWeekly	(!sameWeek(lastTransactionDate, currentTransactionDate, specificDayOfTheWeek));
		
		if (!sameDay(lastTransactionDate, currentTransactionDate)) {
			resetIndicators.setResetDaily(true); 
		}
		return resetIndicators;
	}

	// ------------------------------------------------------------------------------------ //
	
	private boolean sameYear(Date date1, Date date2) {
	
		Calendar cDate1 = Calendar.getInstance(); 
		Calendar cDate2 = Calendar.getInstance(); 
		
		cDate1.setTime(date1);
		cDate2.setTime(date2);
		
		return ( cDate1.get(Calendar.YEAR) == cDate2.get(Calendar.YEAR) );  
	}
	
	// ------------------------------------------------------------------------------------ //
		
	private boolean sameDay(Date date1, Date date2) {
	
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.setTime(date1);
		cal2.setTime(date2);
		
		boolean sameDay = 		( cal1.get(Calendar.YEAR) 			== cal2.get(Calendar.YEAR		)) 
							&&	( cal1.get(Calendar.DAY_OF_YEAR) 	== cal2.get(Calendar.DAY_OF_YEAR));
		
		return (sameDay	);  
	}
	
	// ------------------------------------------------------------------------------------ //
	
	private boolean sameWeek (Date lastTransactionDate, Date currentTransactionDate, int specificDayOfWeek) {

		Calendar cLastTransaction = Calendar.getInstance();
		cLastTransaction.setTime(lastTransactionDate);

		Calendar cCurrentTransaction = Calendar.getInstance();
		cCurrentTransaction.setTime(currentTransactionDate);

		// Same Year (Between Last and current transaction date)
		if (sameYear (lastTransactionDate , currentTransactionDate)) {
			Long 	lastTrs 		= Long.parseLong(yyyyMMdd.format(cLastTransaction.getTime())		); 
			Long 	currTrs 		= Long.parseLong(yyyyMMdd.format(cCurrentTransaction.getTime())		); 
			Long 	daysDifference 	= currTrs - lastTrs; 
			
			if (cLastTransaction.get(Calendar.DAY_OF_WEEK) == specificDayOfWeek) {
				return daysDifference < 7 ? true : false;
			}
			
			else {
				if (daysDifference > 7) {
					return false; 
				}
				else {
					if ( checkIfSpecific_DayOfWeek_Ends_BetweenTwoDates(cLastTransaction, cCurrentTransaction, specificDayOfWeek) ) {
						return false; 
					}
					else {
						return true; 
					}
				}
			}
		}
		else {
			// Different Year (Between Last and current transaction date)
			if ( checkIfSpecific_DayOfWeek_Ends_BetweenTwoDates(cLastTransaction, cCurrentTransaction, specificDayOfWeek) ) {
				return false; 
			}
			else {
				if (checkIfNumberOfDaysExceeded(cLastTransaction, cCurrentTransaction, 7)) {
					return false; 
				}
				else {
					return true; 
				}
			}
		}
	}

	// ------------------------------------------------------------------------------------ //
	private boolean checkIfSpecific_DayOfWeek_Ends_BetweenTwoDates	( 	Calendar 	cStart, 
																		Calendar 	cEnd, 
																		int 		specificDayOfWeek) {
		
		boolean result = false;

		Calendar tmp = Calendar.getInstance();
		tmp.setTime(cStart.getTime());
		tmp.add(Calendar.DATE, 1);
		
		while (tmp.compareTo(cEnd) <= 0) {
			if (tmp.get(Calendar.DAY_OF_WEEK) == specificDayOfWeek) {
				result = true;
				break;
			}
			tmp.add(Calendar.DATE, 1);
		}
		return result;
	}

	
	// ------------------------------------------------------------------------------------ //
	private boolean checkIfNumberOfDaysExceeded (	Calendar 	cStart, 
													Calendar 	cEnd, 
													int 		numberOfDays) {
		boolean result 	= false;
		int 	maxDays = 0; 
		
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(cStart.getTime());
		tmp.add(Calendar.DATE, 1);
		
		while (tmp.compareTo(cEnd) <= 0) {
			if (maxDays > numberOfDays) {
				result = true;
				break;
			}
			tmp.add(Calendar.DATE, 1);
		}
		return result;
	}
		
}
