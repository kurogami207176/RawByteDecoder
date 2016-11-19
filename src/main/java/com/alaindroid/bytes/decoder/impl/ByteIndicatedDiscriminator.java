package com.alaindroid.bytes.decoder.impl;

import java.util.Map;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Discriminator;
import com.alaindroid.bytes.decoder.Translator;
import com.alaindroid.bytes.decoder.util.Util;

public class ByteIndicatedDiscriminator implements Discriminator<ByteArray> {
	public ByteIndicatedDiscriminator(int indexStart, int indexEnd,
			@SuppressWarnings("rawtypes") Map<Integer, Translator> translatorMap) {
		this.indexEnd = indexEnd;
		this.indexStart = indexStart;
		this.translatorMap = translatorMap;
	}

	int indexStart;
	int indexEnd;
	@SuppressWarnings("rawtypes")
	Map<Integer, Translator> translatorMap;

	public Translator<?> getTranslator(ByteArray bytes) {
		Integer indicator = Util.toInteger(bytes, indexStart, indexEnd);
		return translatorMap.get(indicator);
	}

}
