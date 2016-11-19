package com.alaindroid.bytes.decoder.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Separator;
import com.alaindroid.bytes.decoder.bytearray.ByteArrayImpl;

public class ByteIndicatedSeparatorTest {
	Separator separator;

	@Test
	public void test() throws ParseException {
		separator = new ByteIndicatedSeparator(0, 0);
		ByteArray bytes = new ByteArrayImpl(new byte[] { 5, 0, 0, 0, 0, 4, 10, 10, 10, 3, 20, 20, 2, 30 });
		List<ByteArray> split = separator.cut(bytes);
		assertNotNull(split);
		assertEquals(4, split.size());
		for (int i = 0; i < 4; i++) {
			ByteArray spl = split.get(i);
			assertNotNull(spl);
			assertEquals(5 - i, spl.length());
			assertEquals(spl.get(0), spl.length());
			for (int k = 0; k < 5 - i - 1; k++) {
				assertEquals(i * 10, spl.get(k + 1));
			}
		}
	}

	@Test
	public void test2() throws ParseException {
		separator = new ByteIndicatedSeparator(1, 1);
		ByteArray bytes = new ByteArrayImpl(new byte[] { 0, 5, 0, 0, 0, 10, 4, 10, 10, 20, 3, 20, 30, 2 });
		List<ByteArray> split = separator.cut(bytes);
		assertNotNull(split);
		assertEquals(4, split.size());
		for (int i = 0; i < 4; i++) {
			ByteArray spl = split.get(i);
			assertNotNull(spl);
			System.out.println(DatatypeConverter.printHexBinary(spl.getBytes()));
			assertEquals(5 - i, spl.length());
			assertEquals(spl.get(1), spl.length());
			for (int k = 0; k < 5 - i; k++) {
				if (k != 1) {
					assertEquals(i * 10, spl.get(k));
				}
			}
		}
	}

}
