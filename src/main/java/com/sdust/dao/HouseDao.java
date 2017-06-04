package com.sdust.dao;

import com.sdust.model.Complanint;
import com.sdust.model.House;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/20.
 */
@Repository
public class HouseDao {

    public class HouseRowMapper implements RowMapper<House> {
        @Override
        public House mapRow(ResultSet resultSet, int i) throws SQLException {
            House house = new House();
            house.setBuildingNo(resultSet.getInt("buildingNo"));
            house.setHouseArea(resultSet.getDouble("houseArea"));
            house.setHouseStyle(resultSet.getString("houseStyle"));
            house.setPrpertorId(resultSet.getInt("prpertorId"));
            house.setSealState(resultSet.getString("sealState"));
            house.setHouseNo(resultSet.getInt("houseNo"));
            house.setUnitNo(resultSet.getInt("unitNo"));
            return house;
        }
    }
}
