package com.cdeworks.ksocial.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cdeworks.ksocial.repository.dao.UserDAO;
import com.cdeworks.ksocial.repository.model.Associado;

@Repository
public class UserDAOImpl implements UserDAO, UserDetailsService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String jpql = "select a from Associado a where	a.email	=	:email";
		List<Associado> users = em.createQuery(jpql, Associado.class).setParameter("email", username).getResultList();
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("O	associado	" + username + "	não	existe");
		}
		return users.get(0);
	}

}
