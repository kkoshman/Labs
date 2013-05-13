package bsu.osgi.impl;

import bsu.osgi.DecoratorStream;
import bsu.osgi.IAbstractStream;

public class CompressingStream extends DecoratorStream {
	
	public CompressingStream() {}
	public CompressingStream (IAbstractStream pAbstractStream) {
		setAbstractStream(pAbstractStream);
	}

	@Override
	public int putBytes(byte[] pByte) {
		System.out.println("CompressingStream : putBytes");
		IAbstractStream abstractStream = getAbstractStream();
		if (abstractStream != null) {
			abstractStream.putBytes(pByte);
		}
		return 0;
	}

	@Override
	public int putInt(int pInt) {
		System.out.println("CompressingStream : putInt");
		IAbstractStream abstractStream = getAbstractStream();
		if (abstractStream != null) {
			abstractStream.putInt(pInt);
		}
		return 0;
	}

	@Override
	public void handleBufferFull() {
		System.out.println("CompressingStream : handleBufferFull");
		IAbstractStream abstractStream = getAbstractStream();
		if (abstractStream != null) {
			abstractStream.handleBufferFull();
		}
	}


}
