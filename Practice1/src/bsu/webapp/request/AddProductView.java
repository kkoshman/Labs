package bsu.webapp.request;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;

import bsu.orderhandling.command.Command;
import bsu.orderhandling.command.UserMessage;
import bsu.webapp.util.Constants;
import bsu.webapp.util.XSLTCashe;


public class AddProductView extends Command{
	
	public static final String SUCCESS_PAGE = "addProductSuccessView";
	
	private static AddProductView instance = null;
	protected AddProductView() {}
	
	public static synchronized AddProductView getInstance() {
		if (instance == null) {
			instance = new AddProductView();
		}
		return instance;
	}
	
	@Override
	public UserMessage execute() {
		try {
			
			Transformer transformer = XSLTCashe.newTransformer(SUCCESS_PAGE);
			double synch = Math.random() * 1991;
			HttpSession session = (HttpSession) ((CommandMemento) getState()).params.get(Constants.SESSION);

			if (session != null) {
				session.setAttribute(Constants.SYNCHRONIZATION_NUMBER, synch);
				transformer.setParameter(Constants.SYNCHRONIZATION_NUMBER, synch);
			} else {
				session.setAttribute(Constants.SYNCHRONIZATION_NUMBER, null);
			}
			
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserMessage revert() {
		// TODO Auto-generated method stub
		return null;
	}


}
