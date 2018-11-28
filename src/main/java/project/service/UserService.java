package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDAO;
import project.module.Role;
import project.module.User;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("userDetailsService")
public class UserService {

    @Autowired
    private UserDAO dao;

    public UserService() {
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
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