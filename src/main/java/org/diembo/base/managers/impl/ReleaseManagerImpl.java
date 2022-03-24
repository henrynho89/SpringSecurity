package org.diembo.base.managers.impl;

import org.diembo.base.managers.ReleaseManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ReleaseManagerImpl implements ReleaseManager{
	
	String standardRelease = "4.2.001-009-BC";
	
	public String getRelease(){
		return standardRelease;
	}
	
}
