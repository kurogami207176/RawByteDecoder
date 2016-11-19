package com.alaindroid.bytes.decoder.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Separator;

public class FixedLengthSeparator implements Separator {
	private int len;

	public FixedLengthSeparator(int len) {
		this.len = len;
	}

	public List<ByteArray> cut(ByteArray bytes) throws ParseException {
		if (bytes == null || bytes.length() == 0 || bytes.length() % len != 0) {
			throw new ParseException("Invalid byte length", (bytes == null) ? -1 : bytes.length());
		}
		List<ByteArray> retVal = new ArrayList<ByteArray>();
		int index = 0;
		while (index < bytes.length()) {
			ByteArray cut = bytes.extract(index, index + len);
			retVal.add(cut);
			index = index + len;
		}
		return retVal;
	}

}
