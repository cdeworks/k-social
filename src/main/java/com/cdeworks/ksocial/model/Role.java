package com.cdeworks.ksocial.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = -7697398710319811314L;
	
	
	@Id
	private String nomeRole;

	@Override
	public String getAuthority() {
		return nomeRole;
	}

}
