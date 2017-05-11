package com.payu.sdk.paymentplan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;
import com.payu.sdk.model.request.Request;

/**
 * Represents a recurring bill payment retry in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.2.4
 * @version 1.2.4, 11/05/2017
 */
@XmlRootElement(name = "paymentRetry")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RecurringBillPaymentRetry extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7610012078687961244L;

	/** The recurring bill identifier */
	private String recurringBillId;

	/*
	 * (non-Javadoc)
	 * @see com.payu.sdk.model.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants#RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(String baseUrl, RequestMethod requestMethod) {

		return String.format(Resources.DEPENDENT_ENTITY_API_URL_PATTERN, baseUrl, Resources.PAYMENT_PLAN_VERSION,
				Resources.URI_RECURRING_BILL, this.recurringBillId, Resources.URI_RECURRING_BILL_PAYMENT_RETRY);
	}

	public String getRecurringBillId() {

		return recurringBillId;
	}

	public void setRecurringBillId(String recurringBillId) {

		this.recurringBillId = recurringBillId;
	}

}
