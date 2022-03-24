package org.diembo.base.utils.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class WrappedResultSet {
	private ResultSet rs ;

	public WrappedResultSet ( ResultSet rs ) {
		this.rs = rs ;
	}

	public Integer getInt ( String columnLabel ) throws SQLException {
		Integer result = rs.getInt(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public Integer getInt ( String columnLabel , Integer defaultValue ) throws SQLException {
		Integer result = getInt(columnLabel);
		if ( result == null )
			result = defaultValue;
		return result ;
	}

	public Long getLong ( String columnLabel ) throws SQLException {
		Long result = rs.getLong(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public Float getFloat ( String columnLabel ) throws SQLException {
		Float result = rs.getFloat(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public Double getDouble ( String columnLabel ) throws SQLException {
		Double result = rs.getDouble(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public Date getDate ( String columnLabel ) throws SQLException {
		Date result = rs.getDate(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public Timestamp getTimestamp( String columnLabel ) throws SQLException {
		Timestamp result = rs.getTimestamp(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public Boolean getBoolean ( String columnLabel ) throws SQLException {
		Boolean result = rs.getBoolean(columnLabel) ;
		if ( rs.wasNull() ) {
			result = null ;
		}
		return result ;
	}

	public String getString ( String columnLabel ) throws SQLException {
		return rs.getString(columnLabel) ;
	}
}
