package com.delineneo.service;

import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: deline

 * Date: 1/05/13
 * Time: 9:53 PM
 */
@Service
public class PlayerService {

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

    //TODO: Implement this...
    public List<Player> getAllPlayers() {
        String sql = "SELECT id, firstName, lastName FROM Players";
        return jdbcTemplate.query(sql, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    public Player getPlayer(int playerId) {
        String sql = "SELECT id, firstName, lastName from Player where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", playerId);
        return jdbcTemplate.queryForObject(sql, params,
            new RowMapper<Player>() {
                @Override
                public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Player(rs.getInt(1), rs.getString(2), rs.getString(3));
                }
        });
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
}
