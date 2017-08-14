package service;

import dao.UserDao;
import domain.User;

import java.util.List;

public class UserServImpl implements UserServ {

    private static UserDao uDao;

    public UserServImpl(UserDao uDao) {
        this.uDao = uDao;
    }

    public void addNewUser(User user) {
        uDao.create(user);
    }

    public User findUser(Long id) {
        return uDao.read(id);
    }

    public void updateUser(User user) {
        uDao.update(user);

    }

    public void deleteUser(User user) {
        uDao.delete(user);

    }

    public List<User> findAll() {
        return uDao.findAll();
    }

    public User findByLoginAndPassword(String login, String pass) {
        return uDao.findByLoginAndPassword(login, pass);
    }

}
