package com.yuequnqin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuequnqin.dao.UserDao;
import com.yuequnqin.domain.User;

@Repository(value="userDao")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true) //不需要事务支持
	public int isUserExist(User user) {
		
		String sql="select count(id) as tnumber from user where username=? and password=?";
		Object[] object=new Object[]{user.getUsername(),user.getPassword()};
		int[] types=new int[]{Types.VARCHAR,Types.VARCHAR};
		return jdbcTemplate.queryForObject(sql, object,types,Integer.class);
	}

}
