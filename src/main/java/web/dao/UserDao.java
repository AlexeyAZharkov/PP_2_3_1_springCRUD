package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    void changeUser(User user);
    List<User> listUsers();
//    User findUserByCar(String model, int series);
}