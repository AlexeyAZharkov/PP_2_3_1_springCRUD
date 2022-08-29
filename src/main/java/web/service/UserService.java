package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void editUser(Long id);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> listUsers();

//    @Transactional(readOnly = true)
//    User findUserByCar(String model, int series);
}
