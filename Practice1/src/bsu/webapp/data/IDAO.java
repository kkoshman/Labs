package bsu.webapp.data;


public interface IDAO {
	
	public boolean create(IRepositoryItem pItem);
	
	public boolean update(IRepositoryItem pItem);

	public boolean delete(IRepositoryItem pItem);

	public IRepositoryItem[] findAll();

	public IRepositoryItem retrieveById(String pId);

}
