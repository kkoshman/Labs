package bsu.orderhandling.request;

import java.util.ArrayList;
import java.util.List;


public class RequestHistory {
	private static RequestHistory instance = null;
	protected RequestHistory() {}
	public static synchronized RequestHistory getInstance() {
		if (instance == null) {
			instance = new RequestHistory();
		}
		return instance;
	}
	
	public List<RequestHistoryLine> mHistory = new ArrayList<RequestHistoryLine>();
}
