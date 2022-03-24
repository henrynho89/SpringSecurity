package org.diembo.base.enums;


public enum ErrorCode {
	
	// TODO : Allah Yrehmem Lwalidin ajouter tout nouveau Code dans la Map de MessageDaoBred
	
	
	// BRED
	contract_pseudo_already_used,
	contract_pseudo_is_missing,
	bank_identifier_code_not_found,
	exchange_type_is_missing,
	
	
	// CAM
	ct_StatusMismatch,
	trs_InvalidLanguageId,
	trs_InvalidMerchantCode,
	
	
	
	// GENERAL
	id_cant_be_null,
	id_not_found,
	code_cant_be_null,
	code_not_found,
	code_already_exists,
	operation_not_allowed,	
	invalid_action_code,
	name_cant_be_null,
	email_cant_be_null,
	name_already_used,
	fcm_no_key_defined,
	
	external_reference_constraint,
	
	
	file_not_found,
	file_content_error,
	
	
	// PROGRESS LEVEL
	progressLevel_operation_mismacth,
	
	
	// SECURITY
	security_account_grant,
	security_login_password, // "ERR_INV_PASSWORD_ATT"
	security_token_expired,
	security_otp_null,
	security_otp_reference_null,
	security_otp_mismatch,
	security_otp_expired,
	security_otp_burn,
	security_otp_used,
	security_otp_invalid_length,
	security_otp_invalid_period,
	security_otp_invalid_tries_number,
	security_identifier_beta_invalid,
	security_reset_data_invalid,
	
	security_login_invalid,
	security_password_policy_length,
	security_password_policy_trivial,
	security_password_policy_mismatch,
	security_password_already_used,
	security_password_same_character,
	security_password_same_as_login,    
	security_password_invalid,
	security_password_expired,
	security_password_burn,
	security_hold_user,
	security_unknown_user,
	security_invalid_otp,
	security_unknown_channel,
	security_otp_connect_session,  
	security_login_changed,

	app_release_hold,
	app_release_control,
	app_release_already_hold,
	app_release_already_unhold,
	service_not_available_current_version,
	
	reversal_aborted,
	
	
	merchant_not_found,
	
	specific_error,
	resource_not_found,
	mock_implementation,
	
	//legacy_error,
	not_implemented_yet,
	
	unknown_transaction_status,
	
	role_assigned_to_persons,
	
	payment_request_already_processed,
	payment_request_amount_discrepancy,
	payment_request_beneficiary_discrepancy,
	payment_request_invalid_amount,
	payment_request_reference_exists,
	payment_request_account_mismatch,
	
	parameter_missing,
	parameter_wrong_type,
	parameter_mismatch,
	
	


	backend_connection,
	backend_response_format,
	backend_timeout,
	
	backend_error,
	backend_error_bad_request,
	backend_decline,
	backend_show_as_it_is,
	
//	backend_error_not_authorized,
//	backend_error_internal_server_error,
//	backend_error_account_not_found,
//	backend_error_account_balance_insufficient,
//	backend_error_customer_not_found,
//	backend_error_card_not_found,
//	backend_error_check_not_found,
//	backend_error_transfer_not_found,
//	backend_error_account_inactif,
//	backend_error_unauthorized_account,
//	backend_error_wrong_currency,

	
	// SAND BOX
	role_grant,
	
	
	
	// Card
	card_request_no_detail,
	card_request_quantity_too_big,
	card_request_quantity_too_small,
	
	card_order_quantity_positive_only,
	
	card_type_not_found,
	card_unknown_status,
	card_unknown_internet_status,
	card_not_linked_account,
	card_not_linked_contract,
	card_identifier_not_found,
	card_status_not_active,
	card_already_expired,
	card_number_invalid_lenght,
	card_user_not_granted,
	virtual_card_already_exists,
	endowment_request_already_pending,
	
	
	
	cms_manufacturer_code_already_exists,
	cms_shipment_code_already_exists,
	cms_unknown_card_type,
	cms_not_acknowledged,
	cms_already_assigned,
	cms_number_already_exists,
	cms_pin_reset_error,
	
	
	// Technical errors
	function_forbidden,
	
	// Contract
	contract_terminated,
	contract_hold,
	contract_no_linked_account,
	contract_not_linked_to_account,
	contract_start_time,
	contract_end_time,
	contract_capacity_over_load,
	contract_no_default_contract,
	
	amount_multiple,
	amount_smaller_than_floor,
	amount_greater_than_ceiling,
	year_amount_limit,
	year_number_limit,
	month_amount_limit,
	month_number_limit,
	week_amount_limit,
	week_number_limit,
	day_amount_limit,
	day_number_limit,
	contract_already_terminated,
	contract_already_hold,
	contract_already_unhold,
	person_contract_grant,
	product_validity,
	currency_conversion_buy,
	currency_conversion_sell,
	non_linked_beneficiary,
	contract_not_validated_yet,
	contract_not_activated_yet,
	contract_no_account,
	contract_not_found,
	contract_service_denied,	
	contract_main_account_found,
	contract_not_valid_one,
	
	
	//Customer
	customer_id_not_found,
	customer_code_not_found,
	customer_no_contract,
	customer_hold,
	customer_data_doubt,
	customer_type_product_mismatch,
	customer_accounts_max_limit,
	customer_code_missing,
	customer_code_already_exists,
	customer_cant_be_retrevied_by_person,
	customer_mcc_not_found,
	customer_address_missing,

	customer_details_mismatch,

	// ACCOUNT
	account_number_cant_be_null,
	account_id_not_found,
	account_number_not_found,
	account_bban_not_found,
	account_invalid_bban,
	account_user_not_granted,
	account_not_linked_to_msisdn,
	account_linked_to_msisdns,
	account_short_label_cant_be_null,
	account_hold_reason_not_found,
	account_termination_reason_not_found,
	account_terminated,
	account_already_terminated,
	account_balance_not_null,
	account_hold,
	account_already_hold,
	account_missing_credit_account,
	account_negative_amount_not_allowed,
	account_negative_payer_fees_not_allowed,
	account_negative_payee_fees_not_allowed,
	account_negative_comission_not_allowed,
	account_balance_insufficient,
	account_max_limit,
	account_unknown_type,
	account_is_not_payment_instrument,
	account_status_mismatch,
	account_customer_mismatch,
	account_status_not_active,
	fees_mismatch,
	account_linked_to_contract_account,
	
	// ACCOUNT TYPE
	account_type_cant_be_null,
	account_type_service_applicability,

	
	// CURRENCY
	currency_code_cant_be_null,
	currency_code_not_found,
	
	// SERVICE
	service_code_not_found,
	
	// MSISDN
	msisdn_not_hosted,
	msisdn_not_assigned_to_person,
	msisdn_not_assigned_to_account,
	msisdn_not_assigned_to_contract,
	msisdn_assigned_to_persons,
	msisdn_not_known,
	msisdn_already_used,
	msisdn_same_as_current,
	
	msisdn_nmps_onus_unknown,
	msisdn_nmps_offus_unknown,
	
	
	
	// PERSON
	person_id_not_found,
	person_legalId_already_used,
	person_legalId_missing,
	person_address_missing,
	person_already_hold,
	person_authentication_level,
	person_with_no_msisdn,
	person_already_unhold,
	person_definitively_hold,
	person_login_already_used,
	person_code_already_used,
	person_already_linked_to_customer,
	person_login_not_found,
	person_details_mismatch,
	person_legalId_mismatch,

	
	// FAVORITE
	favorite_name_already_used,
	favorite_with_same_parameters,
	
	// SAPHIR FUNCTIONS
	person_function_grant,
	product_or_account_service_grant,
	
	roleType_not_granted,
	
	// MONEY ORDER
	money_order_backend_failed,
	money_order_msisdn_mismatch,
	money_order_msisdn_account,
	money_order_hash_mismatch,

	
	// PAYMENT REQUEST
	payment_request_amount_mismatch,
	payment_request_msisdn_mismatch,
	payment_request_already_done,
	payment_request_reference_not_found,
	
	
	transfer_to_atm_invalid_digest,
	transfer_to_atm_invalid_status,
	transfer_to_atm_invalid_account,
	transfer_to_atm_expired,
	transfer_to_atm_burned,
	
	// TRANSFER REQUEST
	transfer_request_already_approved_by_user,
	transfer_request_threshold_missing,
	transfer_request_execution_date_passed,
	transfer_request_delete_operation_not_allow_by_ni,
	
	//SELF_ENROLMENT
	self_enrolment_no_pending_request_for_msisdn,
	self_enrolment_msisdn_already_used,
	
	
	// NOTIFICATION
	notification_cannot_be_sent,
	notification_no_address,
	
	
	// DISPUTE
	create_dispute_failed,
	
	
	// LIS
	process_incoming_lis_file_failed,
	process_outging_lis_file_failed,
	
	

	
	start_end_date_mismatch,
	err_negatif_number_not_allowed,
	
	
	
	
	json_utils__type_name_not_found,
	errUnexpectedError,
	
	errDecrypt_wrongKeys,

	
	invalid_request,
	
	
	// NCPS
	ncps_unavailable,
	
	
	// SID : NPMS
   sid_backend_connection,
   sid_backend_declined,
	
   rti_backend_connection,
   rti_backend_declined,
	

	// ADVERTISEMENT
   advertisement_hold,
   advertisement_already_unhold,
	
	err_NegativeAmountNotAllowed,
	
	currencies_mismatch,
	
	//PRINTS
	empty_list,
	
	//SmsGateway
	smsGateway_sending_error,
	smsGateway_response_not_valid,
	
	//BillPayment 
	no_bill_to_pay,
	no_merchant_product_to_display, 
	
	//QrCode 
	qrCode_crc_mismatch,
	qrCode_institution_mismatch,
	qrCode_xlsx_max_line,
	
	no_transfer_mode_configured,
	
	//CreditAuthorization
	credit_authorization_missing,
	
	
	sms_sending_failure
	;
//	
//	qs_nonWellFormedQueryString ,
//	qs_invalidLoginOrPassword ,
//	qs_MsisdnMissing ,
//	qs_MessageMissing ,
//
//	noEntityWithGivenCode ,
//	sqlError ,
//
//	db_UnableToPersist ,
//	db_UnableToPersistRollBack ,
//	db_WhileRetrievingEntity ,
//	db_RowVersionChanged ,
//
//	db_MissingEntity ,
//	db_DuplicateEntity ,
//	db_FatalError ,
//
//	ct_Terminated ,
//	ct_Hold ,
//	ct_AccountHold ,
//	ct_CustomerHold ,
//	ct_DayAmountLimit ,
//	ct_WeekAmountLimit ,
//	ct_MonthAmountLimit ,
//	ct_UnableToPersist ,
//	ct_NoContractWithSuchMsisdn ,
//	ct_StatusMismatch ,
//	ct_KeysMismatch ,
//	ct_InvalidBeta ,
//	ct_CustomerIsRequired ,
//	ct_ProductIsRequired ,
//	ct_TelcoNetworkIsRequired ,
//	ct_AliasAlreadyUsed ,
//	
//	ct_NoConnectionFees ,
//	ct_AmountGreaterThanCeiling ,
//
//	ct_NoProductLimit ,
//	ct_PublicKeySaltMismatch ,
//	ct_ContractCodeMandatory ,
//	ct_PLOperationMismatch ,
//	ct_InvalidSubscriptionFrame ,
//	ct_NotHold ,
//	ct_AlreadyTerminated ,
//	ct_AlreadyHold ,
//	ct_NoAccountWithAliasCode ,
//	ct_NoContractWithAliasName ,
//	ct_NoCreditAccount ,
//	ct_NoDebitAccount ,
//	ct_NoSmsAccount ,
//	ct_NoIvrAccount ,
//	ct_NoPriceListForContract ,
//	ct_NoPriceDetailForContract ,
//	ct_outOfPackage ,
//
//	ct_DayNumberLimit ,
//	ct_WeekNumberLimit ,
//	ct_MonthNumberLimit ,
//
//	ct_WalletItemNotActive,
//	ct_NoMainWalletItemForContract,
//	ct_NoLowChannelWalletItemForContract,
//	ct_NoCardWalletItemWithSuchLast4Digits,
//	ct_NoContratWalletItemWithSuchAliasCode,
//
//	ct_MessageTooLongForCurrentChannel,
//
//	// YOua 2013/04/23 : Start Assert usability of a wallet item for a service
//	ct_WalletItemNotForPayment,
//	// YOua 2013/04/23 : End   Assert usability of a wallet item for a service
//
//	ct_UnHoldNotAllowedForProfile,
//
//	errPriceListRangePayee ,
//	errPriceListRangePayer ,
//	errProductLimitRange ,
//
//	co_Pin1Pin2Mismatch,
//	acc_AccountTypeNotFound ,
//	acc_NoAccountForParams ,
//	acc_NoAccountMaxBalance,
//	acc_SrcAndTarCheckAccAreSame,
//	acc_SrcAndTarMobAccAreSame,
//	acc_SrcAndTarCardAccAreSame,
//
//	mc_NoPendingInvoices ,
//	mc_MerchantIsHold ,
//	mc_InvalidMerchantPassword ,
//	mc_NoMerchantWithSuchCode ,
//
//	cs_NationalIdNumberUsed ,
//	cs_NullValueForNotNullField ,
//	cs_LenghtExeedsTheMaximum ,
//	cs_ImportProblem ,
//	cs_ErrorFromHost ,
//
//	trs_ReplayedTransaction ,
//	trs_InvalidTransactionDate,
//	trs_InvalidService ,
//	trs_InvalidLanguageId ,
//	trs_MsisdnMismatch ,
//	trs_InvalidMsisdnLenght ,
//	trs_InvalidBankDecrypt ,
//	trs_InvalidMerchantCode ,
//	trs_InvalidChannelCode ,
//	trs_AmountMultiple ,
//	trs_ServiceNotAvailable ,
//	trs_InvalidPRId ,
//	trs_InvalidPRDetails ,
//	trs_InvalidCheckBookType ,
//	// public static final int errTransactionRequest_unknownType ,
//
//	trs_RolledBack1 ,
//	trs_FailuerWhenRollingdBack ,
//	trs_UnableToCreateInDb ,
//
//	// public static final int errSmsManager_UnableToSendSms ,
//
//	errProcessByTypeError ,
//	errSubscriptionError ,
//
//	errWrongPassword ,
//	errPastPassword ,
//	errPasswordSpecialChar ,
//	errPasswordTooShort ,
//
//	errCodeCantBeNullForEntity ,
//
//	errAccountNotFound ,
//	errRemoteException ,
//	errServiceException ,
//	errSmsSendingUnknwonFailure ,
//	errSmsSendingWellknwonFailure ,
//	errNotEnoughSelectionCrierias ,
//	errAccountNullListSendFromHost ,
//	errActionNotAllowed ,
//	errActionAborted ,
//
//	hst_Error ,
//	hst_UnknownAccountNumber ,
//	hst_UnknownMerchantCode ,
//	hst_NoBillsForThisReference ,
//	hst_MerchantContractOnHold ,
//	hst_InputDataError ,
//	hst_InputAmountError ,
//	hst_InsuffisantBalance ,
//	hst_NoTransactionForAccount ,
//	hst_InvalidSecretCode ,
//	hst_Amount100Multiple ,
//	hst_NoBalance ,
//	hst_NoOperationList ,
//	hst_SystemError ,
//	hst_DbConnectionError ,
//
//	errNoClassDefFoundError  ,
//	errFunctionNotImplemented ,
//	
//	errRequiredFieldNotEntered,
//	errRequiredFieldsNotEntered,
//	
//	
//	pb_cnx_edd,


}
