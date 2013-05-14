package bsu.gof.singleton;

import java.util.HashMap;
import java.util.Map;

public abstract class GOFSingleton {
	private static GOFSingleton _instance;
	private static Map<String, GOFSingleton> _registry = new HashMap<String, GOFSingleton>();
	
	protected GOFSingleton() {
	}
	
	public static void Register(String name, GOFSingleton obj) {
		_registry.put(name, obj);
	}
	
	public static GOFSingleton Instance() {
		if (_instance == null) {
		String name = System.getProperty("bsu.singletonName");
			_instance = GOFSingleton.Lookup(name);
		}
		return _instance;
	}
	
	protected static GOFSingleton Lookup(String name) {
		if (_registry.get(name) == null) {
			try {
				Class.forName(name);
			} catch (ClassNotFoundException cex) {
				System.out.println("Class " + name + " isn't found");
			}
		}
		return (GOFSingleton) _registry.get(name);
	}
}

