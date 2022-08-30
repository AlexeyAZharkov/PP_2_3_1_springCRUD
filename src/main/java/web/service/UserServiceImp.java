package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
   private UserDao userDaoImp = new UserDaoImp();

   public UserServiceImp(UserDao userDaoImp) {
      this.userDaoImp = userDaoImp;
   }

   @Override
   public void addUser(User user) {
      userDaoImp.addUser(user);
   }

   @Override
   public void updateUser(Long id, User updatedUser) {
      userDaoImp.updateUser(id, updatedUser);
   }

   @Override
   public void deleteUser(Long id) {
      userDaoImp.deleteUser(id);
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserById(Long id) {
      return userDaoImp.getUserById(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDaoImp.listUsers();
   }

}
