package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDAO;
import project.module.Role;
import project.module.User;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDAO daoRole;

    public RoleService() {
    }

    public RoleDAO getDao() {
        return daoRole;
    }

    public void setDao(RoleDAO dao) {
        this.daoRole = dao;
    }

    @Transactional
    public void addRole(User user, Role role) {
        daoRole.addRole(user,role);
    }

    @Transactional
    public List<String> getRoles(String login) {
        return daoRole.getRoles(login);
    }

    @Transactional
    public Role findRole(long id) {
        return daoRole.findRole(id);
    }

    @Transactional
    public void removeRole(long id) {
        daoRole.removeRole(id);
    }

    @Transactional
    public void registRole(User user, String userRole) {
        daoRole.registRole(user, userRole);
    }
}