package bsu.gof.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSingleton {

	@Test
	public void testGOFSingleton() {
		// It's impossible to instantiate both GOFSingleton and GOFSubSingleton
		// directly
		// GOFSingleton - because of abstract class
		// GOFSubSingleton - because of private constructor
		// GOFSingleton single = new GOFSingleton();
		// GOFSingleton singlesub = new GOFSubSingleton();

		System.setProperty("bsu.singletonName",
				"bsu.gof.singleton.GOFSubSingleton");
		GOFSingleton singleFirst = GOFSingleton.Instance();
		GOFSingleton singleSecond = GOFSingleton.Instance();

		assertTrue(singleFirst instanceof GOFSubSingleton);
		assertTrue(singleSecond instanceof GOFSubSingleton);
		assertTrue(singleFirst == singleSecond);
	}

	@Test
	public void testEnumSingleton() {
		EnumSingleton esingleFirst = EnumSingleton.INSTANCE;
		EnumSingleton esingleSecond = EnumSingleton.INSTANCE;
		esingleFirst.operation();
		assertTrue(esingleFirst == esingleSecond);
	}

	@Test
	public void testDoubleCheckedSingleton() {
		DoubleCheckedSingleton singleFirst = DoubleCheckedSingleton.getInstance();
		DoubleCheckedSingleton singleSecond = DoubleCheckedSingleton.getInstance();
		singleFirst.operation();
		assertTrue(singleFirst == singleSecond);
	}

	@Test
	public void testNotLazySingleton() {
		NotLazySingleton singleFirst = NotLazySingleton.getInstance();
		NotLazySingleton singleSecond = NotLazySingleton.getInstance();
		singleFirst.operation();
		assertTrue(singleFirst == singleSecond);
	}

	@Test
	public void testOnDemandSingleton() {
		OnDemandSingleton singleFirst = OnDemandSingleton.getInstance();
		OnDemandSingleton singleSecond = OnDemandSingleton.getInstance();
		singleFirst.operation();
		assertTrue(singleFirst == singleSecond);
	}

	@Test
	public void testSynchronizedSingleton() {
		SynchronizedSingleton singleFirst = SynchronizedSingleton.getInstance();
		SynchronizedSingleton singleSecond = SynchronizedSingleton.getInstance();
		singleFirst.operation();
		assertTrue(singleFirst == singleSecond);
	}

	@Test
	public void testGOFSingletonPerformance() {
		int n = 100;
		System.setProperty("bsu.singletonName", "bsu.gof.singleton.GOFSubSingleton");
		Thread[] threads = new RunGOFSingletonThread[n];
		for (int i = 0; i < n; i++) {
			threads[i] = new RunGOFSingletonThread();
		}
		for (int i = 0; i < n; i++) {
			threads[i].start();
		}
		try {
			for (int i = 0; i < n; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public class RunGOFSingletonThread extends Thread{
		@Override
		public void run() {
			GOFSubSingleton single = (GOFSubSingleton)GOFSingleton.Instance();
			//int pause = (int) (Math.random()*1000);
			//try {
				//sleep(pause);
				single.operation();
				//sleep(pause);
				single.operation();
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
		}
	}

}
