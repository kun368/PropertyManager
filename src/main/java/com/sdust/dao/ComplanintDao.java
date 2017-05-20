package com.sdust.dao;

import com.sdust.model.Complanint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/20.
 */
public class ComplanintDao {

    public  class ComplanintRowMapper implements RowMapper<Complanint> {

        @Override
        public Complanint mapRow(ResultSet resultSet, int i) throws SQLException {
            Complanint complanint =new Complanint();
            complanint.setPropertorId(resultSet.getInt("complanintId"));
            complanint.setComDate(resultSet.getDate("comDate"));
            complanint.setComDetail(resultSet.getString("comDetail"));
            complanint.setComplanintId(resultSet.getInt("complanintId"));
            complanint.setSolveState(resultSet.getString("solveState"));
            return complanint;
        }
    }
}
