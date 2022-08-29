package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(Long id);
    void editUser(Long id);
    List<User> listUsers();
//    User findUserByCar(String model, int series);
}
