package com.xmq.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xmq.model.People;

public class PeopleRowMapper implements RowMapper<People> {

	public People mapRow(ResultSet rs, int rowNum) throws SQLException {
		People p = new People();
		// System.out.println("-----------------------person_id-"
		// + rs.getInt("person_id"));
		// p.setId(rs.getInt("person_id"));
		p.setFirstName(rs.getString("first_name"));
		p.setLastName(rs.getString("last_name"));
		return p;
	}

}
