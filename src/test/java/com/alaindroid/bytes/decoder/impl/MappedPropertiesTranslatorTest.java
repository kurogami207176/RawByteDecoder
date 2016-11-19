package com.alaindroid.bytes.decoder.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.alaindroid.bytes.decoder.Translator;
import com.alaindroid.bytes.decoder.impl.support.BytesProperty;

public class MappedPropertiesTranslatorTest {

	Translator translator;

	@Before
	public void setup() {
		List<BytesProperty> props = new ArrayList<BytesProperty>();
		translator = new MappedPropertiesTranslator(props);
	}

	@Test
	public void testDecode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEncode() {
		fail("Not yet implemented");
	}

}
