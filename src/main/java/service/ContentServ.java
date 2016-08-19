package service;

import java.util.List;

import domain.Content;

public interface ContentServ {

	void addNewContent(Content content);
	Content findContent(Long id);
	void updateContent(Content content);
	void deleteContent(Content content);
	List<Content> findAll();
	List<Content> findByString(String str);
	List<Content> findByType(String type);
	List<Content> findByUser(Long id);
	List<Content> findByCatalogAndWord(Long catalog_id,String searched);
}
