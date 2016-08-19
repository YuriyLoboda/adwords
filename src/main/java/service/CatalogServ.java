package service;

import java.util.List;

import domain.Catalog;

public interface CatalogServ {
	
	void addNewCatalog(Catalog cat);
	Catalog findCatalog(Long id);
	void updateCatalog(Catalog cat);
	void deleteCatalog(Catalog cat);
	List<Catalog> findAll();

}
