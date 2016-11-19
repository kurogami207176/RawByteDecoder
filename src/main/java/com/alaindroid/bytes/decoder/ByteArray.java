package com.alaindroid.bytes.decoder;

public interface ByteArray {
	public byte get(int index);

	public ByteArray extract(int indexStart, int indexEnd);

	public ByteArray merge(ByteArray... byteArrays);

	public byte[] getBytes();

	public int length();
}
