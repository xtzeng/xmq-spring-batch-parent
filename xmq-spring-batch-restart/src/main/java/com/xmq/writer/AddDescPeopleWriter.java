package com.xmq.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.xmq.model.PeopleDESC;

@Component
public class AddDescPeopleWriter implements ItemWriter<PeopleDESC> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void write(List<? extends PeopleDESC> items) throws Exception {
        for (PeopleDESC peopleDESC : items) {
            System.out.println("write people desc!!");
            this.jdbcTemplate
                    .update("insert into people_desc (first_name, last_name, batch_desc) values (?, ?, ?)",
                            peopleDESC.getFirstName(),
                            peopleDESC.getLastName(), peopleDESC.getDesc());
        }
    }

}
