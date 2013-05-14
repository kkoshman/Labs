package bsu.gof.singleton;

public class DoubleCheckedSingleton {
	private static volatile DoubleCheckedSingleton instance = null;
	private static final Object lock = new Object();

	private DoubleCheckedSingleton() {
	};

	public static DoubleCheckedSingleton getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new DoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}

	public void operation() {
		System.out.println("Double-Checked Singleton operation.");
	}
}
