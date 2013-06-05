package bsu.webapp.util;

import bsu.webapp.data.DAOMapper;
import bsu.webapp.filter.FilterManager;



public class GlobalApplication {
	private static volatile GlobalApplication instance = null;
	private static final Object lock = new Object();

	private GlobalApplication() {
		mLogger = new Logger();
		mFilterManager = new FilterManager();
		mDAOMapper = new DAOMapper();
	};

	public static GlobalApplication getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new GlobalApplication();
				}
			}
		}
		return instance;
	}
	
	private Logger mLogger;
	private FilterManager mFilterManager;
	private DAOMapper mDAOMapper;
	
	public Logger getLogger() { return mLogger; }
	public FilterManager getFilterManager() { return mFilterManager; }
	public DAOMapper getDAOMapper() { return mDAOMapper; }
}
