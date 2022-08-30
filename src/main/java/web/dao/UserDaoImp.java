package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.controller.Users;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
//    private List<User> listUsers = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.getReference(User.class, id);
        entityManager.remove(user);
    }

//    @Override
//    public void editUser(Long id) {
//        String hqlInsert = "update User u set u.firstName = :newName where u.firstName = :oldName";
//        entityManager.createQuery( hqlInsert );
//    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.getReference(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

}
