package com.lei.jpa.dao;

import com.lei.jpa.exception.CommitException;
import com.lei.jpa.exception.NotFoundException;

public interface GenericDAO<Table, Key>
{
	void register(Table object);
	
	void update(Table object);
	
	Table search(Key key);
	
	void delete(Key key) throws NotFoundException;
	
	void commit() throws CommitException;
}
