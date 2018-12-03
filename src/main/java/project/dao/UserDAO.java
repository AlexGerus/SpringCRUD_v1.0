package project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.module.User;

import java.util.List;
@Repository("userRepository")
public interface UserDAO {
    User getUser(long id);
    long addUser(User usersEntity);
    void removeUser(long id);
    @Query("select user from User user")
    List<User> listUser();
    void changeUser(User usersEntity);
    void registrUser(User usersEntity);
    User getUserWithLogin(String login);
}