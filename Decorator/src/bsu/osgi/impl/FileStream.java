package bsu.osgi.impl;

import bsu.osgi.IAbstractStream;

public class FileStream implements IAbstractStream {

	@Override
	public int putBytes(byte[] pByte) {
		System.out.println("FileStream : putBytes");
		return 0;
	}

	@Override
	public int putInt(int pInt) {
		System.out.println("FileStream : putInt");
		return 0;
	}

	@Override
	public void handleBufferFull() {
		System.out.println("FileStream : handleBufferFull");
	}

}
