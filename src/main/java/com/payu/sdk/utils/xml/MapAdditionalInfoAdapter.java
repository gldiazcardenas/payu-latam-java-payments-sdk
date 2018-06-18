package com.payu.sdk.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility to adapt additional info into {@link MapAdditionalInfoElement} and
 * vice versa.
 *
 * @author PayU Latam
 * @since 1.2.2
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
