package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(Long id, User updatedUser);
    User getUserById(Long id);
    List<User> listUsers();
}
