package com.sdust.view;

import com.sdust.dao.AdminUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangzhengkun on 2017/5/20.
 */
@Component
public class MainView {

    @Autowired private AdminUserDao adminUserDao;

    public void run() {
        //adminUserDao.test();
    }
}
