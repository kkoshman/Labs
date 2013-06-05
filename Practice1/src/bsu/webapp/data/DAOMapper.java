package bsu.webapp.data;

import java.util.HashMap;
import java.util.Map;

import bsu.webapp.data.impl.User;
import bsu.webapp.data.impl.UserDAO;

public class DAOMapper {
	private Map<String, IDAO> mDAOMap = new HashMap<String, IDAO>();
	
	public DAOMapper() {
		addDAO(User.class.getName(), new UserDAO());
	}
	
	public void addDAO(String pItemName, IDAO pItemDAO) {
		if (pItemName != null && pItemDAO != null) {
			mDAOMap.put(pItemName, pItemDAO);
		}
	}
	
	public IDAO getDAO(String pItemName) {
		IDAO dao = null;
		if (pItemName != null) {
			dao = mDAOMap.get(pItemName);
		}
		return dao;
	}
}
