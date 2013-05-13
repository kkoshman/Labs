package bsu.osgi.impl;

import bsu.osgi.DecoratorStream;
import bsu.osgi.IAbstractStream;

public class ASCII7Stream extends DecoratorStream {
	
	public ASCII7Stream() {}
	public ASCII7Stream (IAbstractStream pAbstractStream) {
		setAbstractStream(pAbstractStream);
	}

	@Override
	public int putBytes(byte[] pByte) {
		System.out.println("ASCII7Stream : putBytes");
		IAbstractStream abstractStream = getAbstractStream();
		if (abstractStream != null) {
			abstractStream.putBytes(pByte);
		}
		return 0;
	}

	@Override
	public int putInt(int pInt) {
		System.out.println("ASCII7Stream : putInt");
		IAbstractStream abstractStream = getAbstractStream();
		if (abstractStream != null) {
			abstractStream.putInt(pInt);
		}
		return 0;
	}

	@Override
	public void handleBufferFull() {
		System.out.println("ASCII7Stream : handleBufferFull");
		IAbstractStream abstractStream = getAbstractStream();
		if (abstractStream != null) {
			abstractStream.handleBufferFull();
		}
	}

}
