package org.diembo.base.enums;

public enum BackendSystem {
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	Saphir	("Saphir MFS"),
	HOST	("SI Bancaire"),
	BE		("BackEnd"),
	MPNS	("Mobile Payment National Switch"),
	eMania	("eMania"),

	/**
	 * @deprecated This value is deprecated, please use BILL 
	 */
	@Deprecated
	FATO	("SI Fatourati"),
	BILL	("SI Facturation"),
	/**
	 * @deprecated This value is deprecated, please use MO 
	 */
	@Deprecated
	MAND	("SI Mandati"),
	MO		("SI Mandat"),
	GALL	("SI Galerie"),
	GALL2	("SI Galerie 2"),
	GALL3	("SI Galerie 3"),
	GALL4	("SI Galerie 4"),
	GALL5	("SI Galerie 5"),
	PORTAL	("Portail"),
	PORTAL2	("Portail 2"),
	PORTAL3	("Portail 3"),
	PORTAL4	("Portail 4"),
	PORTAL5	("Portail 5"),
	;
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public String getLabel() { return label ; }
	private BackendSystem (String label) {this.label = label ;}
	private String label ;
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
}
