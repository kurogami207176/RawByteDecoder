package com.alaindroid.bytes.decoder.impl.support;

import com.alaindroid.bytes.decoder.ByteArray;

public class BytesProperty {
	private String name;
	private int indexStart;
	private int indexEnd;

	public BytesProperty(String name, int indexStart, int indexEnd) {
		this.setName(name);
		this.indexStart = indexStart;
		this.indexEnd = indexEnd;
	}

	public ByteArray decode(ByteArray bytes) {
		ByteArray b = bytes.extract(indexStart, indexEnd);
		return b;
	}

	public void encode(ByteArray bytes, Object o) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
