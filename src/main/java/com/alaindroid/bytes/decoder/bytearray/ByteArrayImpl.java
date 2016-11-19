package com.alaindroid.bytes.decoder.bytearray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.alaindroid.bytes.decoder.ByteArray;

public class ByteArrayImpl implements ByteArray {

	byte[] bytes;

	public ByteArrayImpl(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	public byte get(int index) {
		return bytes[index];
	}

	@Override
	public byte[] getBytes() {
		return bytes;
	}

	@Override
	public ByteArray extract(int indexStart, int indexEnd) {
		byte[] b = Arrays.copyOfRange(bytes, indexStart, indexStart);
		return new ByteArrayImpl(b);
	}

	@Override
	public ByteArray merge(ByteArray... byteArrays) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (ByteArray byteArray : byteArrays) {
			byte[] b = byteArray.getBytes();
			try {
				baos.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ByteArrayImpl(baos.toByteArray());
	}

	@Override
	public int length() {
		return bytes.length;
	}

}
