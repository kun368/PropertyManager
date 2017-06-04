package com.sdust.dao;

import com.sdust.model.Complanint;
import com.sdust.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/5/20.
 */
@Repository
public class HouseDao {

    @Autowired private JdbcTemplate jdbc;

    public List<House> allHouse() {
        return jdbc.query("SELECT * FROM house", new HouseRowMapper());
    }

    public void addHouse(House house) {
        jdbc.update("INSERT INTO `house` (`houseId`, `buildingNo`, `unitNo`, `houseNo`, `propertorId`, `sealState`, `houseStyle`, `houseArea`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                new Random().nextInt(),
                house.getBuildingNo(),
                house.getUnitNo(),
                house.getHouseNo(),
                house.getPrpertorId(),
                house.getSealState(),
                house.getHouseStyle(),
                house.getHouseArea());
    }

    public class HouseRowMapper implements RowMapper<House> {
        @Override
        public House mapRow(ResultSet resultSet, int i) throws SQLException {
            House house = new House();
            house.setBuildingNo(resultSet.getInt("buildingNo"));
            house.setHouseArea(resultSet.getDouble("houseArea"));
            house.setHouseStyle(resultSet.getString("houseStyle"));
            house.setPrpertorId(resultSet.getInt("propertorId"));
            house.setSealState(resultSet.getString("sealState"));
            house.setHouseNo(resultSet.getInt("houseNo"));
            house.setUnitNo(resultSet.getInt("unitNo"));
            return house;
        }
    }
}
