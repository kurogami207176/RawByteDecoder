package com.alaindroid.bytes.decoder.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Separator;
import com.alaindroid.bytes.decoder.util.Util;

public class ByteIndicatedSeparator implements Separator {
	int indexStart, indexEnd;

	public ByteIndicatedSeparator(int indexStart, int indexEnd) {
		this.indexStart = indexStart;
		this.indexEnd = indexEnd;
	}

	public List<ByteArray> cut(ByteArray bytes) throws ParseException {
		ByteArray cuttable = bytes;
		List<ByteArray> retVal = new ArrayList<ByteArray>();
		int len = 0;
		try {
			int offset = 0;
			// while (cuttable != null && cuttable.length > 0) {
			while (offset < bytes.length()) {
				len = Util.toInteger(bytes, offset + indexStart, offset + indexEnd);
				if (len <= 0) {
					throw new Exception("Got length: " + len);
				}
				ByteArray nxtByte = cuttable.extract(offset, offset + len);
				retVal.add(nxtByte);
				offset = offset + len;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ParseException(e.getMessage(), -1);
		}

		return retVal;
	}

}
