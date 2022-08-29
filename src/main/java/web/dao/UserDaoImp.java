package web.dao;

import org.springframework.stereotype.Repository;
import web.controller.Users;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private List<User> listUsers = new ArrayList<>();

    EntityManager em = Users.getEntityManager();

    public Users getUser(Long id) {
        EntityManager em = Users.getEntityManager();
        Users user = em.find(Users.class, new Long(1));
        em.detach(user);
        return user;
    }

    @Override
    public void addUser(User user) {
        listUsers.add(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void changeUser(User user) {

    }

    @Override
    public List<User> listUsers() {
        return listUsers;
    }

//   private SessionFactory sessionFactory;
//
//   public UserDaoImp(SessionFactory sessionFactory) {
//      this.sessionFactory = sessionFactory;
//   }
//
//   @Override
//   public void addUser(User user) {
//      sessionFactory.getCurrentSession().save(user);
//   }
//
//   public User findUserByCar(String model, int series) {
//      TypedQuery<User> query=sessionFactory.getCurrentSession()
//              .createQuery("select U from User U inner join U.car as C " +
//                      "with C.series = :paramSeries and C.model = :paramModel ");
//      query.setParameter("paramModel", model);
//      query.setParameter("paramSeries", series);
//      return query.getSingleResult();
//   }
//
//   @Override
//   @SuppressWarnings("unchecked")
//   public List<User> listUsers() {
//      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//      return query.getResultList();
//   }

}
//"""
//CREATE TABLE `spring_crud`.`users` (
//  `id` INT NOT NULL AUTO_INCREMENT,
//  `name` VARCHAR(45) NOT NULL,
//  `last_name` VARCHAR(45) NOT NULL,
//  `email` VARCHAR(45) NOT NULL,
//  PRIMARY KEY (`id`),
//  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
//"""