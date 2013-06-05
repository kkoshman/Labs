package bsu.webapp.data;

public interface IRepositoryItem {
	public String getId();
	public void setId(String pId);
	public boolean exactlyEquals(IRepositoryItem pItem);
	public void copyTo(IRepositoryItem pItem);
}
