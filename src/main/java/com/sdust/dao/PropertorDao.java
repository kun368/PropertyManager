package com.sdust.dao;

import com.sdust.model.Propertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */
@Repository
public class PropertorDao {

    @Autowired private JdbcTemplate jdbc;

    public List<Propertor> findAll() {
        return jdbc.query("SELECT * FROM propertor", new PropertorRowMapper());
    }

    public void add(Propertor propertor) {
        jdbc.update("INSERT INTO `propertor` (`prName`, `prSex`, `prPhone`, `prIdNumber`) VALUES (?, ?, ?, ?)",
                propertor.getPrName(),
                propertor.getPrSex(),
                propertor.getPrPhone(),
                propertor.getPrIdNumber());
    }

    public class PropertorRowMapper implements RowMapper<Propertor> {

        @Override
        public Propertor mapRow(ResultSet resultSet, int i) throws SQLException {
            Propertor propertor=new Propertor();
            propertor.setPrIdNumber(resultSet.getString("prIdNumber"));
            propertor.setPrName(resultSet.getString("prName"));
            propertor.setPrPhone(resultSet.getString("prPhone"));
            propertor.setPrSex(resultSet.getString("prSex"));
            propertor.setPropertorId(resultSet.getInt("propertorId"));
            return propertor;
        }
    }
}
