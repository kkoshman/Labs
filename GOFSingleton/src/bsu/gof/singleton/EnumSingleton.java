package bsu.gof.singleton;

public enum EnumSingleton {
	INSTANCE;

	public void operation() {
		System.out.println("Enum Singleton operation.");
	}
}
