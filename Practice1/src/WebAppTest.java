import static org.junit.Assert.*;

import org.junit.Test;

import bsu.webapp.data.impl.DAOImpl;
import bsu.webapp.data.impl.User;
import bsu.webapp.data.impl.UserDAO;


public class WebAppTest {
	
	protected User getUser1() {
		User user = new User();
		user.setId("user1");
		user.setFirstName("Kate");
		user.setLogin("kkoshman");
		//user.setLastName("Koshman");
		user.setPassword("123");
		return user;
	}
	@Test
	public void testRepositoryItemCopyTo() {
		User user = getUser1();
		User userToCopy = new User();
		userToCopy.setFirstName("Alex");
		userToCopy.setLastName("Mikita");
		userToCopy.setId("user2");
		
		user.copyTo(userToCopy);
		assertTrue(user.getFirstName() == userToCopy.getFirstName());
		assertTrue(user.getLastName() == userToCopy.getLastName());
		assertTrue(user.getId() == userToCopy.getId());
	}
	@Test
	public void testUserDAOToXML() {
		DAOImpl dao = new UserDAO();
		User user = getUser1();
		String xml = dao.toXML(user);
		System.out.println(xml);
		assertTrue(xml.startsWith("<User>"));
		assertTrue(xml.endsWith("</User>"));
		assertTrue(xml.indexOf("<Id>user1</Id>") != -1);
		assertTrue(xml.indexOf("<LastName>") == -1);
	}

}
