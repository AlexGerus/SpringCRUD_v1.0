package project.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.module.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOHibernate implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    public UserDAOHibernate() {}

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public User getUser(long id) {
        return em.find(User.class, id);
    }
    @Transactional
    public long addUser(User usersEntity) {
        em.persist(usersEntity);
        return usersEntity.getId();
    }
    @Transactional
    public void removeUser(long id) {
        User user = getUser(id);
        em.remove(user);
    }

    @Transactional
    public List<User> listUser() {
        return em.createQuery("select user from User user").getResultList();
    }

    @Transactional
    public void changeUser(User usersEntity) {
        User newUser = getUser(usersEntity.getId());
        newUser.setId(usersEntity.getId());
        newUser.setName(usersEntity.getName());
        newUser.setAge(usersEntity.getAge());
        newUser.setLogin(usersEntity.getLogin());
        newUser.setPassword(usersEntity.getPassword());
        em.merge(newUser);
    }

    @Transactional
    public void registrUser(User usersEntity) {
        em.persist(usersEntity);
    }

    @Transactional
    public User getUserWithLogin(String login) {
        return (User) em.createQuery("select user from User user where user.login = :login").setParameter("login", login).getSingleResult();
    }


}