package com.xmq.mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class PeoplePreparedStatementSetter implements PreparedStatementSetter {

    public void setValues(PreparedStatement ps) throws SQLException {
        // TODO Auto-generated method stub
        ps.setString(1, "%xiao%");
        ps.setString(2, "%zeng%");
        // ps.setInt(3, 1);
        // ps.setInt(4, 100);
    }
}
