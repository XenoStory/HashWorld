package com.lei.jpa.dao.impl;

import javax.persistence.EntityManager;

import com.lei.jpa.dao.PlayerDAO;
import com.lei.jpa.entity.Player;

public class PlayerDAOImpl extends GenericDAOImpl<Player, Integer> implements PlayerDAO
{
	public PlayerDAOImpl(EntityManager em) 
	{
		super(em);
	}
}
