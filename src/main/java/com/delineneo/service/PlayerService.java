package com.delineneo.service;

import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * User: deline

 * Date: 1/05/13
 * Time: 9:53 PM
 */
@Service
public class PlayerService {

    private SimpleJdbcInsert simpleJdbcInsert;

    public int save(final Player player) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("firstName", player.getFirstName());
        params.put("lastName", player.getLastName());
        Number number = simpleJdbcInsert.executeAndReturnKey(params);
        return number.intValue();
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
            .withTableName("Player")
            .usingGeneratedKeyColumns("id");
    }
}
