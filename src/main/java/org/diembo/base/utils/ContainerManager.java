package org.diembo.base.utils;

import java.util.Collection;

public interface ContainerManager extends Container {
	public void subscribe(Container container) ;
	public void unsubscribe(Container container) ;
	public Collection<Container> getInstances() ;
}
