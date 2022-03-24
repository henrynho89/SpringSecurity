package org.diembo.base.utils;

public interface Container {
	public <T> T getObject(String name, Class<T> type);

	public <T> T getObjectIfAny(String name, Class<T> type);
}
