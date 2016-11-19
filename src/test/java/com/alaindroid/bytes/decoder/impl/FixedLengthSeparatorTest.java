package com.alaindroid.bytes.decoder.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Separator;
import com.alaindroid.bytes.decoder.bytearray.ByteArrayImpl;

public class FixedLengthSeparatorTest {

	Separator separator;

	@Test
	public void test() throws ParseException {
		separator = new FixedLengthSeparator(3);
		ByteArray bytes = new ByteArrayImpl(new byte[] { 0, 0, 0, 10, 10, 10, 20, 20, 20, 30, 30, 30 });
		List<ByteArray> split = separator.cut(bytes);
		assertNotNull(split);
		assertEquals(4, split.size());
		for (int i = 0; i < 4; i++) {
			ByteArray spl = split.get(i);
			assertNotNull(spl);
			assertEquals(3, spl.length());
			for (int k = 0; k < 3; k++) {
				assertEquals(i * 10, spl.get(k));
			}
		}
		//fail("Not yet implemented");
	}

}
