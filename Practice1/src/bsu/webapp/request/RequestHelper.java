package bsu.webapp.request;

import javax.servlet.http.HttpServletRequest;

import bsu.orderhandling.request.Request;

public class RequestHelper {
	public static Request prepareRequest (HttpServletRequest pRequest) {
		// TODO Add session to map
		return new Request();
	}
}
