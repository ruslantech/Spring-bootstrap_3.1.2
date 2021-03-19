package com.ruslantech.springbootstrap.Springbootstrap_312.dao;

import com.ruslantech.springbootstrap.Springbootstrap_312.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        TypedQuery<Role> query =  entityManager.createQuery("from Role", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
