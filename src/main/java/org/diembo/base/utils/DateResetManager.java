package org.diembo.base.utils;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

public interface DateResetManager {
			
	// TODO : Check if static doesn't represent re-entrance potential clash
	/// SOS SOS SOS SOS SOS SOS SOS SOS SOS SOS   STATIC
	
	public static class ResetIndicators {
				
		public boolean resetDaily; 
		public boolean resetWeekly;
		public boolean resetMonthly;
		public boolean resetYearly;
		
		public boolean isResetDaily() {
			return resetDaily;
		}
		
		public void setResetDaily(boolean resetDaily) {
			this.resetDaily = resetDaily;
		}
		
		public boolean isResetWeekly() {
			return resetWeekly;
		}
		public void setResetWeekly(boolean resetWeekly) {
			this.resetWeekly = resetWeekly;
		}
		
		public boolean isResetMonthly() {
			return resetMonthly;
		}
		public void setResetMonthly(boolean resetMonthly) {
			this.resetMonthly = resetMonthly;
		}
		
		public boolean isResetYearly() {
			return resetYearly;
		}
		public void setResetYearly(boolean resetYearly) {
			this.resetYearly = resetYearly;
		}
	}
	
	
	/**
	 * Returns Indicators that will indicate whether to reset or not 
	 * the different totals  
	 * @param 	lastTransactionDate 
	 * @param 	currentTransactionDate
	 * @param 	specificDayOfWeek (Reset Week Day)
	 * @return 	ResetIndicators class
	 * 		--> resetDaily 		: True/False 
	 * 		--> resetWeekly 	: True/False
	 * 		--> resetMonthly 	: True/False
	 * 		--> resetYearly 	: True/False
	 * 
	 */
	@Transactional(readOnly = true)
	public ResetIndicators reset (Date  lastTransactionDate , Date currentTransactionDate , int specificDayOfWeek);


}
