package com.sdust.dao;

import com.sdust.model.Payment;
import com.sdust.model.PaymentType;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/20.
 */
@Repository
public class PaymentTypeDao {
    public class  PaymentTypeRowMapper implements RowMapper<PaymentType>{

        @Override
        public PaymentType mapRow(ResultSet resultSet, int i) throws SQLException {
            PaymentType paymentType=new PaymentType();
            paymentType.setPayType(resultSet.getString("payType"));
            paymentType.setPayTypeId(resultSet.getInt("payTypeId"));
            return paymentType;
        }
    }
}
