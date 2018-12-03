package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDAOHibernate;
import project.module.User;
import java.util.List;


@Service("userDetailsService")
public class UserService {

    @Autowired
    private UserDAOHibernate dao;

    public UserService() {
    }

    public UserDAOHibernate getDao() {
        return dao;
    }

    public void setDao(UserDAOHibernate dao) {
        this.dao = dao;
    }

    @Transactional
    public long addUser(User usersEntity) {
        return dao.addUser(usersEntity);
    }

    @Transactional
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Transactional
    public void removeUser(long id) {
        dao.removeUser(id);
    }

    @Transactional
    public List<User> listUser() {
        return dao.listUser();
    }

    @Transactional
    public void changeUser(User usersEntity) {
        dao.changeUser(usersEntity);
    }

    @Transactional
    public void registrUser(User usersEntity) {
        dao.registrUser(usersEntity);
    }

    @Transactional
    public User getUserLogin(String login) {
        return dao.getUserWithLogin(login);
    }
}