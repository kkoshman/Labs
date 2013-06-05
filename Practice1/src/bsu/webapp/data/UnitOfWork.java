package bsu.webapp.data;

import java.util.HashSet;
import java.util.Set;

import bsu.webapp.util.GlobalApplication;

public class UnitOfWork {
	protected Set<IRepositoryItem> mNewItems = new HashSet<IRepositoryItem>();
	protected Set<IRepositoryItem> mCopyItems = new HashSet<IRepositoryItem>();
	protected Set<IRepositoryItem> mDirtyItems = new HashSet<IRepositoryItem>();
	protected Set<IRepositoryItem> mRemovedItems = new HashSet<IRepositoryItem>();
	
	public void registerClear(IRepositoryItem pItem) {
		//check
		mCopyItems.add(pItem);
	}
	
	public void registerNew(IRepositoryItem pItem) {
		//check
		mNewItems.add(pItem);
	}
	
	public void registerDirty(IRepositoryItem pItem) {
		//check
		mDirtyItems.add(pItem);
	}
	
	public void registerRemoved(IRepositoryItem pItem) {
		//check
		mRemovedItems.add(pItem);
	}
	
	public void commit() {
		DAOMapper daoMapper = GlobalApplication.getInstance().getDAOMapper();
		for (IRepositoryItem item : mNewItems) {
			IDAO dao = daoMapper.getDAO(item.getClass().getName());
			dao.create(item);
		}
		for (IRepositoryItem item : mDirtyItems) {
			IDAO dao = daoMapper.getDAO(item.getClass().getName());
			if (isDirty(item)) {
				dao.update(item);
			}
		}
		for (IRepositoryItem item : mRemovedItems) {
			IDAO dao = daoMapper.getDAO(item.getClass().getName());
			dao.delete(item);
		}
	}
	
	private boolean isDirty(IRepositoryItem pItem) {
		boolean dirty = false;
		if (pItem != null) {
			IRepositoryItem item = getClearItem(pItem.getId());
			dirty = !pItem.exactlyEquals(item);
		}
		return dirty;
	}
	
	private IRepositoryItem getClearItem(String pId) {
		IRepositoryItem item = null;
		if (pId != null) {
			for (IRepositoryItem copy : mCopyItems) {
				if (copy.getId().equals(pId)) {
					item = copy;
					break;
				}
			}
		}
		return item;
	}

	public void rollback() {
		for (IRepositoryItem item : mDirtyItems) {
			IRepositoryItem clearItem = getClearItem(item.getId());
			clearItem.copyTo(item);
		}
		mNewItems.clear();
		mDirtyItems.clear();
		mRemovedItems.clear();
		//mCopyItems.clear();
	}
}
