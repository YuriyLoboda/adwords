package service;

import java.util.List;

import domain.User;

public interface UserServ {
	
	void addNewUser(User user);
	User findUser(Long id);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> findAll();
	User findByLoginAndPassword(String login,String pass);
}
