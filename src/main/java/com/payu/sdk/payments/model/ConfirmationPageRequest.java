/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016 developers-payu-latam
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.payu.sdk.payments.model;

import com.payu.sdk.constants.Resources;
import com.payu.sdk.model.request.CommandRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a notification request in the PayU SDK.
 *
 * @author PayU Latam
 * @version 1.2.3, 28/03/2017
 * @since 1.2.3
 */
@XmlRootElement(name = "request") @XmlAccessorType(XmlAccessType.FIELD)
public class ConfirmationPageRequest extends CommandRequest {

	/**
	 * The generated serial version Id
	 */
	private static final long serialVersionUID = 1;

	/**
	 * The transaction id
	 */
	@XmlElement(required = true) private String transactionId;

	/**
	 * Returns the transaction id
	 *
	 * @return the transaction id
	 */
	public String getTransactionId() {

		return transactionId;
	}

	/**
	 * Sets the transaction id
	 *
	 * @param transactionId the transaction id to set
	 */
	public void setTransactionId(String transactionId) {

		this.transactionId = transactionId;
	}

	/*
	 * (non-Javadoc)
	 * @see com.payu.sdk.model.request.Request#getBaseRequestUrl(
	 * java.lang.String, com.payu.sdk.constants.Resources.RequestMethod)
	 */
	@Override protected String getBaseRequestUrl(String baseUrl,
			Resources.RequestMethod requestMethod) {

		return String.format(Resources.PARAM_ENTITY_API_URL_PATTERN, baseUrl,
				Resources.PAYMENT_PLAN_VERSION, Resources.URI_SEND_CONFIRMATION_PAGE,
				this.transactionId);
	}

}
