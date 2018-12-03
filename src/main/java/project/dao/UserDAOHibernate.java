package project.dao;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usersEntity.setPassword(bCryptPasswordEncoder.encode(usersEntity.getPassword()));
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User newUser = getUser(usersEntity.getId());
        newUser.setId(usersEntity.getId());
        newUser.setName(usersEntity.getName());
        newUser.setAge(usersEntity.getAge());
        newUser.setLogin(usersEntity.getLogin());
        newUser.setPassword(encoder.encode(usersEntity.getPassword()));
        em.merge(newUser);
    }

    @Transactional
    public void registrUser(User usersEntity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        usersEntity.setPassword(bCryptPasswordEncoder.encode(usersEntity.getPassword()));
        usersEntity.setEnabled(true);
        em.persist(usersEntity);
    }

    @Transactional
    public User getUserWithLogin(String login) {
        return em.createQuery("select user from User user where user.login = :login", User.class).setParameter("login", login).getSingleResult();
    }


}