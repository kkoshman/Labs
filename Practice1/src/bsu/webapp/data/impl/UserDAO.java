package bsu.webapp.data.impl;

import bsu.webapp.data.IRepositoryItem;

public class UserDAO extends DAOImpl {

	@Override
	public boolean update(IRepositoryItem pUser) {
		if (pUser instanceof User) {
			//TODO
		}
		return true;
	}

	@Override
	public boolean delete(IRepositoryItem pUser) {
		if (pUser instanceof User) {
			//TODO
		}
		return true;
	}

	@Override
	public IRepositoryItem[] findAll() {
		return null;
	}

	@Override
	public boolean create(IRepositoryItem pUser) {
		if (pUser instanceof User) {
			//TODO
		}
		return true;
	}

	@Override
	public IRepositoryItem retrieveById(String pId) {
		return null;
	}
	
}