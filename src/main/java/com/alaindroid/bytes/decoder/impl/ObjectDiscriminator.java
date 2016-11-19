package com.alaindroid.bytes.decoder.impl;

import java.util.Map;

import com.alaindroid.bytes.decoder.Discriminator;
import com.alaindroid.bytes.decoder.Translator;

public class ObjectDiscriminator implements Discriminator<Object> {
	public ObjectDiscriminator(@SuppressWarnings("rawtypes") Map<Class<?>, Translator> translatorMap) {
		this.translatorMap = translatorMap;
	}

	@SuppressWarnings("rawtypes")
	Map<Class<?>, Translator> translatorMap;

	public Translator<?> getTranslator(Object bytes) {
		return translatorMap.get(bytes.getClass());
	}

}
