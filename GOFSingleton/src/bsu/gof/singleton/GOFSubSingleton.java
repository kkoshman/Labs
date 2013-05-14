package bsu.gof.singleton;

public class GOFSubSingleton extends GOFSingleton{
	static {
		new GOFSubSingleton();
	}

	private GOFSubSingleton() {
		GOFSingleton.Register(this.getClass().getName(), this);
	}

	public void operation() {
		System.out.println("GOF Singleton operation.");
	}

}
