package com.alaindroid.bytes.decoder.impl.support;

import java.util.function.Function;

import com.alaindroid.bytes.decoder.ByteArray;

public class Property {
	Function<ByteArray, Object> f;

	private Property(Function<ByteArray, Object> f) {
		this.f = f;
	}

	public Object translate(ByteArray bytes) {
		return f.apply(bytes);
	}

}
