package org.diembo.base.utils;

public enum GenerateTokenAction {
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
		
	/*** Burn			*/	B ("Verify Token Then burn it ")	,
	/*** UpdateExpiry	*/	U ("Update expiry")					,
	/*** DoNothing		*/	N ("Do nothing")					,
	;

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
		
	public static GenerateTokenAction Burn 			= B;
	public static GenerateTokenAction UpdateExpiry 	= U;
	public static GenerateTokenAction DoNothing		= N;
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
		
	public	String	getLabel	() { return label ; }
	
	private GenerateTokenAction ( String label ) {
		this.label = label ;
	}
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
		
	private String	label ;
}
