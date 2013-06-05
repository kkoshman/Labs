package bsu.webapp.data.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bsu.webapp.data.IRepositoryItem;

public class RepositoryItemImpl implements IRepositoryItem {
	private String mId;
	
	public String getId() {
		return mId;
	}
	public void setId(String pId) {
		this.mId = pId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IRepositoryItem) {
			return equalsOrNulls(getId(), ((IRepositoryItem)obj).getId());
		} else {
			return false;
		}
	}
	
	public boolean exactlyEquals(IRepositoryItem pItem) {
		boolean equals = false;
		if (getClass().isInstance(pItem)) {
			equals = true;
			Method[] methods = pItem.getClass().getMethods();
			Object[] emptyParams = new Object[0];
			try {
				for (Method method : methods) {
					String name = method.getName();
					if (name.startsWith("get") && !"getClass".equals(name)) {
						Object myProperty =  method.invoke(this, emptyParams);
						Object itProperty =  method.invoke(pItem, emptyParams);
						if (!equalsOrNulls(myProperty, itProperty)) {
							equals = false;
							break;
						}
					}
				}
			} catch (IllegalAccessException e) {
				equals = false;
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				equals = false;
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				equals = false;
				e.printStackTrace();
			} catch (SecurityException e) {
				equals = false;
				e.printStackTrace();
			}
		}
		return equals;
	}
	
	@Override
	public void copyTo(IRepositoryItem pItem) {
		if (getClass().isInstance(pItem)) {
			Method[] methods = pItem.getClass().getMethods();
			Object[] emptyParams = new Object[0];
			Object[] oneParam = new Object[1];
			try {
				for (Method method : methods) {
					String name = method.getName();
					if (name.startsWith("get") && !"getClass".equals(name)) {
						String cleanName = name.substring(3);
						Object property =  method.invoke(this, emptyParams);
						Class<?> propertyClass = method.getReturnType();
						Method setMethod = pItem.getClass().getMethod("set" + cleanName, propertyClass);
						if (setMethod != null) {
							oneParam[0] = property;
							setMethod.invoke(pItem, oneParam);
						}
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean equalsOrNulls(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else {
			return obj1.equals(obj2);
		}
	}
}
