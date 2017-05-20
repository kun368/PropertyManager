package com.sdust.dao;

import com.sdust.model.Repair;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/20.
 */
public class RepairDao {
    public class  RepairRowMapper implements RowMapper<Repair>{

        @Override
        public Repair mapRow(ResultSet resultSet, int i) throws SQLException {
            Repair repair=new Repair();
            repair.setHouseId(resultSet.getInt("houseId"));
            repair.setRepairdata(resultSet.getDate("reapirdata"));
            repair.setRepairDetail(resultSet.getString("repairDetail"));
            repair.setRepairState(resultSet.getString("repairState"));
            repair.setRepairManId(resultSet.getInt("repairManId"));
            repair.setRepairId(resultSet.getInt("repairId"));
            return  repair;
        }
    }
}
