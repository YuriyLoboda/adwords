package dao;

import java.util.List;

import domain.Catalog;

public interface CatalogDao {
	Long create(Catalog catalog);
	Catalog read(Long id);
	void update(Catalog catalog);
	void delete(Catalog catalog);
	List<Catalog> findAll();
}
