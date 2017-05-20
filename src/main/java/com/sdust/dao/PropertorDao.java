package com.sdust.dao;

import com.sdust.model.Propertor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/20.
 */
public class PropertorDao {
    public class PropertorRowMapper implements RowMapper<Propertor>{

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
