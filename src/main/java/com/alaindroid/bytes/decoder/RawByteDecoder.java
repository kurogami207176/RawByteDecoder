package com.alaindroid.bytes.decoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.alaindroid.bytes.decoder.bytearray.ByteArrayImpl;

public class RawByteDecoder {
	Separator separator;
	Discriminator<ByteArray> fromByteDiscriminator;
	Discriminator<Object> toByteDiscriminator;

	public RawByteDecoder(Separator separator, Discriminator fromByteDiscriminator, Discriminator toByteDiscriminator) {
		this.separator = separator;
		this.fromByteDiscriminator = fromByteDiscriminator;
		this.toByteDiscriminator = toByteDiscriminator;
	}

	public List<Object> decode(ByteArray bytes) throws ParseException {
		List<ByteArray> bytesArrayList = separator.cut(bytes);
		List<Object> retVal = new ArrayList<Object>();
		for (ByteArray bytesArrayItem : bytesArrayList) {
			@SuppressWarnings("rawtypes")
			Translator translator = fromByteDiscriminator.getTranslator(bytesArrayItem);
			if (translator != null) {
				Object o = translator.decode(bytesArrayItem);
				if (o != null) {
					retVal.add(o);
				}
			}
		}

		return retVal;
	}

	public ByteArray encode(List<Object> objects) throws ParseException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (Object o : objects) {
			Translator t = toByteDiscriminator.getTranslator(o);
			baos.write(t.encode(o).getBytes());
		}
		return new ByteArrayImpl(baos.toByteArray());

	}
}
