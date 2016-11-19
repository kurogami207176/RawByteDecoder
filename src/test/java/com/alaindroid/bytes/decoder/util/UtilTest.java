package com.alaindroid.bytes.decoder.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.bytearray.ByteArrayImpl;

public class UtilTest {

	private static ByteArray TESTABLE = new ByteArrayImpl(new byte[] { 5, 4, 3, 2, 1, 0 });

	@Test
	public void test() {
		assertEquals(5, Util.toInteger(TESTABLE, 0));
		assertEquals(4, Util.toInteger(TESTABLE, 1));
		assertEquals(3, Util.toInteger(TESTABLE, 2));
		assertEquals(2, Util.toInteger(TESTABLE, 3));
		assertEquals(1, Util.toInteger(TESTABLE, 4));
		assertEquals(0, Util.toInteger(TESTABLE, 5));
		assertEquals(256, Util.toInteger(TESTABLE, 4, 5));
	}

}
