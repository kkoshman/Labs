package bsu.webapp.util;

public class Logger {
	private boolean mEnabled = true;
	
	public void logMessage(String pMessage, Object pSender) {
		if (mEnabled) {
			System.out.println("[INFO] " + pSender.getClass().toString() + ": " + pMessage);
		}
	}
	public void logError(String pMessage, Object pSender) {
		if (mEnabled) {
			System.out.println("[ERROR] " + pSender.getClass().toString() + ": " + pMessage);
		}
	}
}
