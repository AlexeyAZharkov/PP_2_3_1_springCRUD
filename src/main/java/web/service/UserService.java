package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(Long id);
//    void editUser(Long id);
    void updateUser(Long id, User updatedUser);
    User getUserById(Long id);
    List<User> listUsers();

//    @Transactional(readOnly = true)
//    User findUserByCar(String model, int series);
}
