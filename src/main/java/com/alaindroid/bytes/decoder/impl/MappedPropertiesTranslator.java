package com.alaindroid.bytes.decoder.impl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Translator;
import com.alaindroid.bytes.decoder.impl.support.BytesProperty;

public class MappedPropertiesTranslator implements Translator<Map<String, ByteArray>> {
	public List<BytesProperty> properties;

	public MappedPropertiesTranslator(List<BytesProperty> properties) {
		this.properties = properties;
	}

	@Override
	public Map<String, ByteArray> decode(ByteArray bytes) throws ParseException {
		Map<String, ByteArray> retVal = new HashMap<String, ByteArray>();
		for (BytesProperty prop : properties) {
			ByteArray o = prop.decode(bytes);
			retVal.put(prop.getName(), o);
		}
		return retVal;
	}

	@Override
	public ByteArray encode(Map<String, ByteArray> object) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}
}
