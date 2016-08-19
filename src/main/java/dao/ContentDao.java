package dao;

import java.util.List;

import domain.Content;

public interface ContentDao {
	Long create(Content content);
	Content read(Long id);
	void update(Content content);
	void delete(Content content);
	List<Content> findAll();
	List<Content> findBySmthString(String str);
	List<Content> findByTypeOfCatalog(String type);
	List<Content>findByUser_id(Long id);
	List<Content> findByCatalogAndWord(Long catalog_id,String searched);
}
