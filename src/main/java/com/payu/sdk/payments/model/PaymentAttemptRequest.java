/**
 * The MIT License (MIT)
 * Copyright (c) 2016 developers-payu-latam
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.payu.sdk.payments.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.constants.Resources.RequestMethod;

/**
 * Payment attempt request.
 *
 * @author PayU Latam
 * @since 1.2.7
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentAttemptRequest extends PaymentRequest {

	/** The class serial version. */
	private static final long serialVersionUID = 1L;

	/** The payment request id. */
	@XmlTransient
	private Integer paymentRequestId;

	/**
	 * Default constructor.
	 * Necessary for JAXB marshaler
	 */
	@SuppressWarnings("unused")
	private PaymentAttemptRequest() {

		// Mandatory constructor.
	}

	/**
	 * Class constructor.
	 * 
	 * @param paymentRequestId the payment request id.
	 */
	public PaymentAttemptRequest(final Integer paymentRequestId) {

		this.paymentRequestId = paymentRequestId;
	}

	/*
	 * (non-Javadoc)
	 * @see com.payu.sdk.model.request.Request#getBaseRequestUrl(java.lang.String,
	 * com.payu.sdk.constants.Resources.RequestMethod)
	 */
	@Override
	protected String getBaseRequestUrl(final String baseUrl, final RequestMethod requestMethod) {

		return String.format(Resources.DEPENDENT_ENTITY_API_URL_PATTERN, baseUrl, Resources.V4_3,
				Resources.URI_PAYMENT_REQUEST, getPaymentRequestId(), "transaction");
	}

	/**
	 * @return the paymentRequestId
	 */
	public Integer getPaymentRequestId() {

		return paymentRequestId;
	}

	/**
	 * @param paymentRequestId the paymentRequestId to set
	 */
	public void setPaymentRequestId(final Integer paymentRequestId) {

		this.paymentRequestId = paymentRequestId;
	}
}