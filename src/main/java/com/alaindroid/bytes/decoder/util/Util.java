package com.alaindroid.bytes.decoder.util;

import com.alaindroid.bytes.decoder.ByteArray;

public class Util {

	public static int toInteger(ByteArray bytes, int index) {
		return toInteger(bytes, index, index);
	}

	public static int toInteger(ByteArray bytes, int indexStart, int indexEnd) {
		int len = indexEnd - indexStart + 1;
		int i = indexStart;
		int ctr = 0;
		int d = 1;
		int retVal = 0;
		if (len < 0) {
			len = len * -1;
			i = indexEnd;
			d = -1;
		}
		while (ctr < len) {
			retVal = retVal * (0xFF + 1) + bytes.get(i);
			i = i + d;
			ctr++;
		}

		return retVal;
	}
}
