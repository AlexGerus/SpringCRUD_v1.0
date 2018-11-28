package project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.module.Role;
import project.module.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleDAO {

    @PersistenceContext
    private EntityManager em;

    public RoleDAO() {
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void addRole(User user, Role role) {
        role.setUser(user);
        em.persist(role);
    }

    @Transactional
    public List<String> getRoles(String login) {
        return em.createQuery("select role.nameRole from Role role").getResultList();
    }

    @Transactional
    public Role findRole(long id) {
        return (Role) em.createQuery("select role from Role role where role.userId =:userId").setParameter("userId", id).getSingleResult();
    }

    @Transactional
    public void removeRole(long id) {
        Role role = findRole(id);
        em.remove(role);
    }

    @Transactional
    public void registRole(User user, String userRole) {
        Role role = new Role();
        role.setNameRole(userRole);
        role.setUser(user);
        em.persist(role);
    }
}