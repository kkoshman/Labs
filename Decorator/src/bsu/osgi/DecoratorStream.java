package bsu.osgi;


public abstract class DecoratorStream implements IAbstractStream {

	private IAbstractStream mAbstractStream;

	public IAbstractStream getAbstractStream() {
		return mAbstractStream;
	}

	public void setAbstractStream(IAbstractStream pAbstractStream) {
		this.mAbstractStream = pAbstractStream;
	}

}
