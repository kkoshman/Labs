package bsu.osgi.test;

import org.junit.Test;

import bsu.osgi.IAbstractStream;
import bsu.osgi.StreamFactory;

public class DecoratorTester {
	
	@Test
	public void testBasicStream() {
		IAbstractStream stream = StreamFactory.getStream("FileStream");
		stream.putInt(4);
	}
	
	@Test
	public void testDecoratedStream() {
		IAbstractStream stream = StreamFactory.getStream("FileStream", new String[]{"ASCII7Stream","CompressingStream"});
		stream.putInt(4);
	}
}
