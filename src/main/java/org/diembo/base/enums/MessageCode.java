package org.diembo.base.enums;

public enum MessageCode {
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	A21	("Demande de Relevé"),
	A33	("Retrait Cash"),
	A41	("Recharge Compte Mobile – Dépôt Agence"),
	A42	("Recharge Compte Mobile – Virement"),
	A43	("Recharge Compte Mobile – Carte ABB"),
	A50	("Retrait Mandat"),
	A51	("Demande Expiration Mandat"),
	A52	("Notification Retrait Cash"),
	A53	("Notification Recharge Compte Mobile"),

	A60	("Validation Contrat"),
	A61	("Impression Contrat"),
	A62	("Changement Numéro Téléphone"),
	A63	("Changement Portefeuille"),
	A64	("Changement Produit"),
	A65	("Blocage Contrat"),
	A66	("Déblocage Contrat"),
	A67	("Ré-initialisation PIN"),
	A68	("Ré-initialisation Mot de Passe"),
	A69	("Résiliation Contrat"),
	A70	("Liste de Produits"),
	A71	("Souscription"),
	A72	("Conversion Solde Fidélité"),
	A80	("Activation Contrat"),

	A81	("Demande Liste Mandats"),
	A82	("Demande Annulation Mandat"),
	
	I01	("Profil"),
	I02	("Activation"),
	I03	("Changement Mot de Passe"),

	WA41("Avis Achat de Recharge"),
	WA51("Avis Paiement Factures"),
	WA52("Avis Paiement Internet"),

	WR10("Annulation Autorisation"),
	WR13("Annulation Crédit Compte"),
	WR30("Annulation Mandat"),
	WR32("Annulation Virement vers Compte"),
	WR34("Annulation Virement vers Carte"),
	WR36("Annulation Virement vers mon Compte"),
	WR37("Annulation Retrait Mandat"),
	WR41("Annulation Recharge"),
	WR51("Annulation Paiement Factures"),
	WR52("Annulation Paiement Internet"),
	WR70("Annulation Paiment Commerçant"),

	WS10("Autorisation"),
	WS11("Annulation"),
	WS12("Contrôle Crédit Compte"),
	WS13("Crédit Compte"),
	
	WS19("multi balance inquiry"),
	WS20("Consultation"),
	WS21("Consultation Solde"),
	WS22("Consultation Historique des Opérations"),
	WS23("Liste des Comptes"),
	WS24("Liste des Cartes"),
	WS25("Consultation RIB – iBAN"),
	WS26("Consultation RIB – iBAN"),
	WS27("Consultation Mandat"),
	WS28("Demande Création Mandat GAB"),
	WS29("Demande"),
	WS30("Demande Création Mandat Agence"),
	WS31("Demande Création Mandat GAB MY SELF"),
	WS32("Virement vers Mobile"),
	WS33("Virement vers Compte"),
	WS34("Virement vers Carte"),
	WS35("Virement vers Compte Épargne"),
	WS36("Virement vers mon Compte"),
	WS37("Retrait Mandat"),
	WS38("Recurring Transfer"),
	WS39("Update Transfer"),
	WS40("Delete Transfer"),
	WS41("Achat de Recharge"),
	WS42("Transfers List"),
	WS51("Paiement Factures"),
	WS52("Paiement Internet"),
	WS52BIS("Liste des commerçants"),
	WS54("Demande Liste des Factures"),
	WS55("Demande Liste des Paiements Internet"),
	WS56("Lookup Payment Transaction"),

	WS60("Demande Carte"),
	WS61("Demande Chéquier"),
	WS62("Demande LCN"),
	WS63("Mise en Opposition de Carte"),
	WS64("Mise en Opposition de Chèque"),
	WS65("Mise à jour Statut Carte"),
	WS66("Certification Chèque"),
	WS68("List of Checks"),
	WS70("Recherche Liste Comptes/Cartes"),
	WS71("Recherche Compte"),
	WS72("Recherche Carte"),
	WS73("Liste des Bénéficiaires"),
	WS74("Liste des Comptes Bénéficiaires"),
	WS75("Liste des Mobiles Bénéficiaires"),
	WS76("Liste des Individus Bénéficiaires"),
	WS77("MAJ Contrat"),
	WS77BIS("Non Authenticated Reset Pin"),
	WS78("Recherche détail client"),
	WS79("Demande Réponse Dernière Transaction"),
	WS80("Demande CVV2"),
	
	WS82("Changement PIN"),
	WS83("Recalcul PIN"),
	WS83BIS("Recalcul PIN -- Extended"),
	WS84("Mise à jour des comptes/cartes client"),

	WS90("Liste Articles"),
	
	WS91("Demande Liste des services"),
	WS92("Demande Liste des marchants"),
	WS93("Demande Liste des instruments"),

	WS96("Retrait Mandat UPU"),
	WS97("Retrait Mandat MANDATI"),
	
	WS113("Load Customer"),
	WS114("Create Contract"),

	WS120("Login"),
	WS122("UserAuthentication"),
	WS123("LoginUser"),
	WS124("LogoutUser"),

	WS125("Virement International"),
	WS126("Change User Password"),
	WS127("Functs List"),
	
	WS140("Maintain Beneficiary Account"),
	WS150("Loans List"),
	WS160("Update Card"),
	WS170("Update Check"),
	WS180("Pricing"),

	WS190("Maintain Payment Beneficiary"),
	WS191("Payment Beneficiaries List"),
	
	WS192("Maintain TopUp Beneficiary"),
	WS193("TopUp Beneficiaries List"),
	
	WS194("Maintain Beneficiary Mobile"),
	WS195("Beneficiaries Mobile List"),
	
	WS210("Specific BillPayment"),
	
	WS220("Update Customer Details"),
	WS221("Customer Enrollment Details Lookup"),
	WS222("Create Customer"),
	WS223("Contract Details Lookup"),
	WS224("Contract Operations List"),
	WS225("Contract Connections List"),
	WS226("Maintain Contract Pseudo"),

	WS227("TransactionsList"),
	WS228("Contract Services List"),
	WS229("Lookup Customer"),

	
	WS230("Generate Token"),
	WS231("Activation Contrat avec Token"),
	WS232("Change Otp Communication Details"),

	WS233("Print Change Otp Communication Details"),
	
	WS240("Create Account"),
	WS241("Update Account"),
	WS242("Hold Account"),
	WS243("Unhold Account"),
	WS244("Terminate Account"),
	WS245("Terminate Accounts"),
	
	WS250("Debit Account"),
	WS251("Credit Account"),
	WS252("Credit Accounts"),
	WS253("Transfert Between Accounts"),
	WS254("Reverse Account Operation"),
	WS255("CashIn"),
	WS256("CashOut"),
	
	WS257("Print CashIn"),
	WS258("Print CashOut"),

	WS259("Cash Transactions List"),

	WS262("Print Change Msisdn Doc"),
	WS263("Print Change wallet items Doc"),
	WS264("Print Change product Doc"),
	
	WS265("Print Hold Contract Doc"),
	WS266("Print UnHold Contract Doc"),
	WS267("Print Reset Pin Doc"),
	WS269("Print Terminate Contract Doc"),
	
	WS282("Print Corporate General Contract Doc"),
	WS283("Print Corporate User Contract Doc"),
	
	WS290("Maintain Transfer Order"),
	WS291("Transfer Order List"),
	WS292("Approuve Transfer Order"),
	WS293("Reject Transfer Order"),
	WS294("Escalate Transfer Order"),
	WS295("Execute Transfer Order"),
	WS296("Create Transfer Order Log"),
	WS297("Execute International Transfer Order"),

	
	WS300("ContractLessBalanceInquiry"),
	WS301("SpecialAccountsBalances"),
	WS303("ContractLessStatementInquiry"),
	
	WS310("Maintain MerchantCashOut Order"),
	WS311("MerchantCashOut Order List"),
	WS312("Approve MerchantCashOut Order"),
	WS313("Reject MerchantCashOut Order"),
	WS314("Execute MerchantCashOut Order"),
	WS315("Create Merchant Cash Out Log"),
	
	
	WS320("Bulk Beneficiary Accounts List"),
	WS321("Maintain Bulk Beneficiary Accounts List"),
	WS322("Create Bulk Account transfer List"),
	
	WS330("Maintain MerchantPayment Order"),
	WS331("MerchantPayment Order List"),
	WS332("Approve MerchantPayment Order"),
	WS333("Reject MerchantPayment Order"),
	WS334("Execute MerchantPayment Order"),
	WS335("Create MerchantPayment Log"),
	
	
	WS340("Create Wallet Item"),
	
	WS342("Hold Wallet Item"),
	WS343("Unhold Wallet Item"),
	WS344("Terminate Wallet Item"),
	
	WS380("Payment Reconc Summary"),
	
	WS395("Contract Less Customer Details Lookup"),
	
	WS435("TopUp Cancellation"),

	WS440("Virtual Card Order"),
	WS441("Card Lookup"),
	WS442("Renew Card"),
	WS443("Replace Card"),
	WS444("Terminate Card"),
	
	WS450("Bill Payment Cancellation"),
	WS455("Internet Payment Cancellation"),
	
	WS457("Finish Light Subscription"),
	
	WS459("Light subscription"),

	WS460("Finish Card Order"),
	WS462("Finish Renew Card"),
	WS463("Finish Replace Card"),
	WS464("Finish Terminate Card"),
	
	WS465("Self Enrollment"),
	WS692("Branch Enrollment"),
	WS693("Rbanch Reset Password"),
	
	WS480("Light Activation"),


	WS535("TopUp Refund"),
	WS550("BillPayment Refund"),
	WS555("InternetPayment Refund"),

	WS600("AccountAuditLogsList"),
	
	WS650("Print Link Other Customer Wallet Item"),
	WS651("Link Other Customer Wallet Item"),
	WS652("Print UnLink Other Customer Wallet Item"),
	WS653("UnLink Other Customer Wallet Item"),
	
	WS654("setContractNotificationsToken"),

	
	WS670("Merchant Payment"),
	WS671("Merchant Bill Payment"),
	WS672("Merchant TopUp"),
	WS673("Merchant Transactions List"),
	WS675("Merchant CashIn"),
	WS676("Merchant CashOut"),

	WS677("Print Merchant CashIn"),
	WS678("Print Merchant CashOut"),
	
	WS679("Merchant Activity"),
	
	WS690("Authorized Wallet Item Types"),
	
	WS691("Contract Less Generate Token"),
	
	WS700("National Mobile Transfer"),
	
	WS750("Enroll Wallet Item"),
	WS751("Disenroll Wallet Item"),
	WS752("Lookup Wallet Item"),
	WS760("Ping"),
	WS761("Change Interface Password"),

	BE14("Fichier Région"),
	
	BF01("Fichier Agence"),
	BF02("Fichier Alertes/Événements"),
	BF03("Fichier Alimentation en Masse"),
	BF04(""),
	BF05("Fichier Création en Masse de Comptes Mobiles"),
	BF06(""),
	BF07("Fichier Mise à Jour Client"),
	BF08("Fichier Ville"),
	BF09("Fichier des Notifications non Clôturées"),
	BF10("Fichier de rapprochement"),
	BF11("Fichier Utilisateurs"),
	BF12("Fichier Notifications Retrait Cash"),
	BF13("Fichier Notifications Recharge Mobile"),

	SF01("Fichier CRE"),
	SF02(""),
	SF03("Fichier Rapprochement"),
	SF04("Fichier Retour Alimentation en Masse"),
	SF05("Fichier Annulations non Clôturées"),
	SF06("Fichier Opérations Expirées"),
	SF07("Fichier Retour Création en Masse"),
	SF08("Fichier Log SMS"),
	SF09("Fichier Agrégats Comptables"),
	SF10("Fichier Avis Paiement Factures"),
	SF11("Fichier Règlement et facturation commerçants"),

	SP01("Fichier Spécifique 1"),
	SP02("Fichier Spécifique 2"),
	SP03("Fichier Spécifique 3"),
	SP04("Fichier Spécifique 4"),
	SP05("Fichier Spécifique 5"),
	
	
	FWS41("Terminer l'Achat de Recharge"),
	
	
	
	;
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public String getLabel() { return label ; }
	private MessageCode (String label) {this.label = label ;}
	private String label ;
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
}
