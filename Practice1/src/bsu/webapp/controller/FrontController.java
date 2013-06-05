package bsu.webapp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bsu.orderhandling.command.UserMessage;
import bsu.orderhandling.request.Request;
import bsu.orderhandling.request.RequestHandler;
import bsu.webapp.request.RequestHelper;
import bsu.webapp.request.ViewHandler;
import bsu.webapp.util.GlobalApplication;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 3272862975987113756L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		String uri = req.getRequestURI();
		GlobalApplication.getInstance().getLogger().logMessage("uri="+uri, this);
		String url = req.getRequestURL().toString();
		GlobalApplication.getInstance().getLogger().logMessage("url="+url, this);
		
		//super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	}
	
	@SuppressWarnings("unchecked")
	protected void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		GlobalApplication.getInstance().getFilterManager().executeFilterChain(req, resp);
		//resp.getWriter().append("Answer");
        RequestHandler command = RequestHandler.getInstance();
		Request request = RequestHelper.prepareRequest(req);
        UserMessage message = command.handleRequest(request);
        
        ViewHandler view = ViewHandler.getInstance();
        
        if (message != null) {
        	view.handleRequest(request);
        }

	}
}
