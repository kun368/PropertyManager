package com.sdust.view;

import com.sdust.dao.AdminUserDao;
import com.sdust.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by zhangzhengkun on 2017/5/20.
 */

@Component
public class MainView {

    @Autowired private AdminUserDao adminUserDao;
    @Autowired private UserView userView;
    @Autowired private ProprietorView proprietorView;
    AdminUser user;

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("用户名：");
        String username = sc.nextLine();
        System.out.print("密码：");
        String password = sc.nextLine();
        user = adminUserDao.findUser(username, password);
        while (user == null) {
            System.out.println("用户不存在或者密码错误,请重新输入");
            System.out.print("用户名：");
            username = sc.nextLine();
            System.out.print("密码：");
            password = sc.nextLine();
            user = adminUserDao.findUser(username, password);
        }
        System.out.println("登录成功");
        mainControl();
    }

    public void mainControl() {
        if (user.getUserType() == 0) {
            while (true) {
                mainItemSyso();
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        userView.run();
                        break;
                    case 2:
                        proprietorView.run();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 0:
                        return;
                }
            }
        }
    }

    public void mainItemSyso() {
        System.out.println("===============");
        System.out.println("1.管理系统用户");
        System.out.println("2.管理业主信息");
        System.out.println("3.管理楼盘信息");
        System.out.println("4.管理投诉信息");
        System.out.println("5.管理报修信息");
        System.out.println("6.管理缴费信息");
        System.out.println("0.退出系统");
        System.out.println("===============");
    }
}
