package com.sdust.dao;

import com.sdust.model.Payment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/20.
 */
public class PaymentDao {


    public class PaymentRowMapper implements RowMapper<Payment> {
        @Override
        public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
            Payment payment = new Payment();
            payment.setHouseId(resultSet.getInt("houseId"));
            payment.setPayAmount(resultSet.getDouble("payAmount"));
            payment.setPayDate(resultSet.getDate("payDate"));
            payment.setPayTypeId(resultSet.getInt("payTypeId"));
            payment.setPaymentId(resultSet.getInt("paymentId"));
            return payment;
        }
    }
}
