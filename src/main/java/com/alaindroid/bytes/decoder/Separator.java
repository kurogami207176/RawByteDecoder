package com.alaindroid.bytes.decoder;

import java.text.ParseException;
import java.util.List;

/**
 * Separates a byte array into smaller byte array
 * 
 * @author AlainAnne
 *
 */
public interface Separator {
	public List<ByteArray> cut(ByteArray bytes) throws ParseException;
}
