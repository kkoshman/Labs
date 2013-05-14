package bsu.gof.singleton;

public class NotLazySingleton {
	private static final NotLazySingleton instance = new NotLazySingleton();

	private NotLazySingleton() {
	};

	public static synchronized NotLazySingleton getInstance() {
		return instance;
	}

	public void operation() {
		System.out.println("Not Lazy Singleton operation.");
	}
}
