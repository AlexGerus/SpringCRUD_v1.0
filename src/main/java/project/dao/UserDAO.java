package project.dao;

import project.module.User;

import java.util.List;

public interface UserDAO {
    public User getUser(long id);
    public long addUser(User usersEntity);
    public void removeUser(long id);
    public List<User> listUser();
    public void changeUser(User usersEntity);
    public void registrUser(User usersEntity);
    public User getUserWithLogin(String login);
}