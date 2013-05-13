package bsu.osgi;

public interface IAbstractStream {
	public int putBytes (byte [] pByte);
	public int putInt (int pInt);
	public void handleBufferFull();
}
