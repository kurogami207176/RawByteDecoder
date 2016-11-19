package com.alaindroid.bytes.decoder.impl.support;

import java.nio.ByteBuffer;
import java.util.function.Function;

public enum PropertyType {
	STRING(f -> new String(f)), // to string
	INTEGER(f -> ByteBuffer.wrap(f).getInt()), // to integer
	LONG(f -> ByteBuffer.wrap(f).getLong()), // to long
	FLOAT(f -> ByteBuffer.wrap(f).getFloat()), // to float
	DOUBLE(f -> ByteBuffer.wrap(f).getDouble()), // to double
	BYTE(f -> f[0]); // to bit
	Function<byte[], Object> f;

	private PropertyType(Function<byte[], Object> f) {
		this.f = f;
	}

	public Object translate(byte[] bytes) {
		return f.apply(bytes);
	}
}
