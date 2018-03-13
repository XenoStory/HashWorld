package com.lei.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import com.lei.jpa.dao.GenericDAO;
import com.lei.jpa.exception.CommitException;
import com.lei.jpa.exception.NotFoundException;

public class GenericDAOImpl<Table, Key> implements GenericDAO<Table, Key>
{
	
	private EntityManager manager;
	
	private Class<Table> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) 
	{
		clazz = (Class<Table>)
			((ParameterizedType)
				getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
	}

	@Override
	public void register(Table object) 
	{
		manager.persist(object);
	}

	@Override
	public void update(Table object) 
	{
		manager.merge(object);
	}

	@Override
	public Table search(Key key) 
	{
		return manager.find(clazz, key);
	}

	@Override
	public void delete(Key key) throws NotFoundException 
	{
		Table t = search(key);
		if(t == null)
		{
			throw new NotFoundException("Player not found on our database!");
		}
		manager.remove(t);
	}

	@Override
	public void commit() throws CommitException 
	{
		try
		{
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		}
		catch(Exception e)
		{
			if(manager.getTransaction().isActive())
			{
				e.printStackTrace();
				throw new CommitException("Error commiting information!");
			}
		}
	}
	
}
