package com.alaindroid.bytes.decoder;

import java.text.ParseException;

public interface Translator<T> {
	public T decode(ByteArray bytes) throws ParseException;

	public ByteArray encode(T object) throws ParseException;
}
