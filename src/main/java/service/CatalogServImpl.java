package service;

import dao.CatalogDao;
import domain.Catalog;

import java.util.List;

public class CatalogServImpl implements CatalogServ {

    private static CatalogDao catDao;

    public CatalogServImpl(CatalogDao catDao) {
        this.catDao = catDao;
    }

    public void addNewCatalog(Catalog cat) {
        catDao.create(cat);
    }

    public Catalog findCatalog(Long id) {
        return catDao.read(id);
    }

    public void updateCatalog(Catalog cat) {
        catDao.update(cat);

    }

    public void deleteCatalog(Catalog cat) {
        catDao.delete(cat);

    }

    public List<Catalog> findAll() {
        return catDao.findAll();
    }

}
