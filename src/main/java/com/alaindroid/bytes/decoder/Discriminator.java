package com.alaindroid.bytes.decoder;

import java.text.ParseException;

/**
 * Determines the translator for a byte array
 * 
 * @author AlainAnne
 *
 */
public interface Discriminator<T> {
	public Translator getTranslator(T o) throws ParseException;
}
