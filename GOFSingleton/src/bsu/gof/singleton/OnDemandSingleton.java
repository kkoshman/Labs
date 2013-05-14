package bsu.gof.singleton;

public class OnDemandSingleton {
	private OnDemandSingleton() {
	}

	private static class InstanceHolder {
		public static OnDemandSingleton instance = new OnDemandSingleton();
	}

	public static OnDemandSingleton getInstance() {
		return InstanceHolder.instance;
	}

	public void operation() {
		System.out.println("OnDemand Singleton operation.");
	}
}
