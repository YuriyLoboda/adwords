package service;

import dao.ContentDao;
import domain.Content;

import java.util.List;

public class ContentServImpl implements ContentServ {

    private static ContentDao cDao = null;

    public ContentServImpl(ContentDao cDao) {
        this.cDao = cDao;
    }

    public void addNewContent(Content content) {
        cDao.create(content);

    }

    public Content findContent(Long id) {
        return cDao.read(id);
    }

    public void updateContent(Content content) {
        cDao.update(content);
    }

    public void deleteContent(Content content) {
        cDao.delete(content);
    }

    public List<Content> findAll() {
        return cDao.findAll();
    }

    public List<Content> findByString(String str) {
        return cDao.findBySmthString(str);
    }

    public List<Content> findByType(String type) {
        return cDao.findByTypeOfCatalog(type);
    }

    public List<Content> findByUser(Long id) {
        return cDao.findByUser_id(id);
    }

    public List<Content> findByCatalogAndWord(Long catalog_id, String searched) {

        return cDao.findByCatalogAndWord(catalog_id, searched);
    }


}
