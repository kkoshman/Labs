package bsu.webapp.data.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bsu.webapp.data.IDAO;
import bsu.webapp.data.IRepositoryItem;

public class DAOImpl implements IDAO {

	@Override
	public boolean create(IRepositoryItem pItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(IRepositoryItem pItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(IRepositoryItem pItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IRepositoryItem[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRepositoryItem retrieveById(String pId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toXML(IRepositoryItem pItem) {
		StringBuilder sb = new StringBuilder();
		if (pItem != null) {
			String[] classTerms = pItem.getClass().getName().split("\\.");
			String className = pItem.getClass().getName();
			if (classTerms.length > 0) {
				className = classTerms[classTerms.length - 1];
			}
			sb.append("<").append(className).append(">");
			Method[] methods = pItem.getClass().getMethods();
			Object[] emptyParams = new Object[0];
			try {
				for (Method method : methods) {
					String name = method.getName();
					if (name.startsWith("get") && !"getClass".equals(name)) {
						Object property = method.invoke(pItem, emptyParams);
						if (property != null) {
							String cleanName = name.substring(3);
							sb.append("<").append(cleanName).append(">");
							sb.append(property);
							sb.append("</").append(cleanName).append(">");
						}
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			sb.append("</").append(className).append(">");
		}
		return sb.toString();
	}
}
