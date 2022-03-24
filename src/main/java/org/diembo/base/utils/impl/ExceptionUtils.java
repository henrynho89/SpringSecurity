package org.diembo.base.utils.impl;

import java.net.SocketException;
import java.net.SocketTimeoutException;


public class ExceptionUtils {
	public static String lookupAllMessages ( Throwable t ) {
		StringBuffer messages = new StringBuffer();
		String sep = "" ;
		do {
			messages.append(sep).append(t.getMessage());
			t = t.getCause() ;
			sep = ", due to: " ;
		} while ( t != null ) ;
		return messages.toString();
	}

	public static boolean isReversalRequiredException ( Throwable t ) {
		// This method should be tuned to separate exceptions that requires
		// reversal from those that don't.
		boolean result = false ;

		while ( t != null ) {
			if ( t instanceof SocketTimeoutException ) {
				result = true ;
				break ;
			}
			if ( t instanceof SocketException && "Connection reset".equals(t.getMessage()) ) {
				result = true ;
				break ;
			}
			t = t.getCause() ;
		}

		return result ;
	}

}
