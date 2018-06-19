/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 developers-payu-latam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.payu.sdk.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility to adapt additional info into {@link MapAdditionalInfoElement} and
 * vice versa.
 *
 * @author PayU Latam
 * @since 1.3.2
 * @version 1.0.0, 15/06/2018
 */
public class MapAdditionalInfoAdapter extends XmlAdapter<MapAdditionalInfoElement, Map<String, String>> {

	@Override
	public MapAdditionalInfoElement marshal(Map<String, String> v) throws Exception {

		if (v == null || v.isEmpty()) {
			return null;
		}

		MapAdditionalInfoElement map = new MapAdditionalInfoElement();
		map.setCardType(v.get("cardType"));
		return map;
	}

	@Override
	public Map<String, String> unmarshal(MapAdditionalInfoElement v) throws Exception {

		if (v == null) {
			return null;
		}

		Map<String, String> map = new HashMap<String, String>(1);
		map.put("cardType", v.getCardType());
		return map;
	}
}
