package com.alaindroid.bytes.decoder.bytearray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.alaindroid.bytes.decoder.ByteArray;

public class ByteArrayRelativeImpl implements ByteArray {

	byte[] bytes;
	int indexStart;
	int indexEnd;

	public ByteArrayRelativeImpl(byte[] bytes) {
		this.bytes = bytes;
		this.indexStart = 0;
		this.indexEnd = bytes.length;
	}

	public ByteArrayRelativeImpl(byte[] bytes, int indexStart, int indexEnd) {
		this.bytes = bytes;
		this.indexStart = indexStart;
		if (this.indexStart < 0) {
			this.indexStart = 0;
		}
		this.indexEnd = indexEnd;
		if (indexEnd >= bytes.length) {
			this.indexEnd = bytes.length - 1;
		}
	}

	@Override
	public byte get(int index) {
		return bytes[indexStart + index];
	}

	@Override
	public ByteArray extract(int indexStart, int indexEnd) {
		int nStart = this.indexStart + indexStart;
		int nEnd = this.indexStart + indexEnd;
		if (nEnd >= bytes.length) {
			nEnd = bytes.length - 1;
		}
		return new ByteArrayRelativeImpl(bytes, nStart, nEnd);
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
		return new ByteArrayRelativeImpl(baos.toByteArray());
	}

	@Override
	public byte[] getBytes() {
		byte[] b = Arrays.copyOfRange(bytes, indexStart, indexStart);
		return b;
	}

	@Override
	public int length() {
		return indexEnd - indexStart;
	}

}
