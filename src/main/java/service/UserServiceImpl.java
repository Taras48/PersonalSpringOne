package service;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(User user) {
userDao.updateUser(user);
    }

    public void deletUser(Long id) {
userDao.deletUser(id);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
