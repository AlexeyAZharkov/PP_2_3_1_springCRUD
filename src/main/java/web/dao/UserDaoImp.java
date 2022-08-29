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
    private List<User> listUsers = new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;


//    entityManager.getTransaction().begin()

//    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("web");
//    EntityManager em = emf.createEntityManager();
//    Users user = em.find(Users.class, 1);


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.getReference(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void editUser(Long id) {
        String hqlInsert = "update User u set u.firstName = :newName where u.firstName = :oldName";
//        String hqlInsert = "delete from User c where c.firstName = :oldName";
        entityManager.createQuery( hqlInsert );

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.getReference(User.class, id);
    }

    @Override
    public List<User> listUsers() {
//        System.out.println(entityManager.createQuery("select u from User u", User.class).getResultList());
        return entityManager.createQuery("select u from User u", User.class).getResultList();

//        return listUsers;
    }

}
