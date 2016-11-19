package com.alaindroid.bytes.decoder.impl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.alaindroid.bytes.decoder.ByteArray;
import com.alaindroid.bytes.decoder.Translator;
import com.alaindroid.bytes.decoder.bytearray.ByteArrayImpl;

import junit.framework.TestCase;

@SuppressWarnings("rawtypes")
public class ByteIndicatedDiscriminatorTest extends TestCase {
	private ByteIndicatedDiscriminator discriminator;
	private Map<Integer, Translator> translatorMap;
	private Translator mock1;
	private Translator mock2;
	private Translator mock3;

	@Override
	protected void setUp() throws Exception {
		mock1 = new MockT();
		mock2 = new MockT();
		mock3 = new MockT();
		translatorMap = new HashMap<Integer, Translator>();
		translatorMap.put(1, mock1);
		translatorMap.put(2, mock2);
		translatorMap.put(3, mock3);
		discriminator = new ByteIndicatedDiscriminator(0, 0, translatorMap);
	}

	public void testGetTranslator() {
		ByteArray bytes;
		Translator t;

		bytes = new ByteArrayImpl(new byte[] { 1, 2, 3 });
		t = discriminator.getTranslator(bytes);
		assertEquals(t, mock1);

		bytes = new ByteArrayImpl(new byte[] { 2, 3, 4 });
		t = discriminator.getTranslator(bytes);
		assertEquals(t, mock2);

		bytes = new ByteArrayImpl(new byte[] { 3, 4, 5 });
		t = discriminator.getTranslator(bytes);
		assertEquals(t, mock3);

		bytes = new ByteArrayImpl(new byte[] { 4, 5, 6 });
		t = discriminator.getTranslator(bytes);
		assertNull(t);
	}

	private class MockT implements Translator {

		@Override
		public Object decode(ByteArray bytes) throws ParseException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ByteArray encode(Object object) throws ParseException {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
