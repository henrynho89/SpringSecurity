package org.diembo.base.msg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DataPagging {

	private Long						pagesCount			;
	private Long						currentPageNumber	;
	private Long						pageSize			;
	
	public Long getPagesCount() {
		return pagesCount;
	}
	public void setPagesCount(Long pagesCount) {
		this.pagesCount = pagesCount;
	}
	public Long getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(Long currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}


	
}
