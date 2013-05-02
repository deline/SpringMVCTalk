package com.delineneo.service;

import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * User: deline

 * Date: 1/05/13
 * Time: 9:53 PM
 */
@Service
public class PlayerService {

    private SimpleJdbcInsert simpleJdbcInsert;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int save(final Player player) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstName", player.getFirstName());
        params.addValue("lastName", player.getLastName());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
            " INSERT INTO Player(firstName, lastName) VALUES(:firstName, :lastName);",
            params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
            .withTableName("Player")
            .usingGeneratedKeyColumns("id");

        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
