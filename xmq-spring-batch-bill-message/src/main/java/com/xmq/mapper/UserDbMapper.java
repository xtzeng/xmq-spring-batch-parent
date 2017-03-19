package com.xmq.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xmq.model.User;

public class UserDbMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int i) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setName(rs.getString("NAME"));
		user.setAge(rs.getInt("AGE"));
		user.setBalance(rs.getDouble("BALANCE"));
		return user;
	}

}
