package bsu.gof.singleton;

public class SynchronizedSingleton {
	private static SynchronizedSingleton instance = null;

	private SynchronizedSingleton() {
	};

	public static synchronized SynchronizedSingleton getInstance() {
		if (instance == null) {
			instance = new SynchronizedSingleton();
		}
		return instance;
	}

	public void operation() {
		System.out.println("Synchronized Singleton operation.");
	}
}
