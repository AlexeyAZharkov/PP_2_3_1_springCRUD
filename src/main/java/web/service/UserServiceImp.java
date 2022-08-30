package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
   private UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }

//   @Override
//   public void editUser(Long id) {
//      userDao.editUser(id);
//   }

   @Override
   public void updateUser(Long id, User updatedUser) {
      userDao.updateUser(id, updatedUser);
   }

   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
