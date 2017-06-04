package com.sdust.view;

import com.sdust.dao.AdminUserDao;
import com.sdust.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/24.
 */
@Component
public class UserView {

    @Autowired private AdminUserDao adminUserDao;

    public void run() {
        userSyso();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 1:
                allUser();
                break;
            case 2:
                addUser();
                break;
            case 3:
                modifyUser();
                break;
            case 0:
                break;
        }
    }

    public void allUser() {
        List<AdminUser> query = adminUserDao.allUser();
        System.out.println("|    用户名    |    密码    |    邮箱    |");
        for (int i = 0; i < query.size(); i++) {
            System.out.println(query.get(i).toString());
        }
        run();
    }

    public void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("设置用户名：");
        String username = sc.nextLine();
        System.out.print("设置密码：");
        String password = sc.nextLine();
        System.out.print("设置邮箱：");
        String email = sc.nextLine();
        try {
            adminUserDao.addUser(username, password, email);
        } catch (Exception e) {
            System.err.println("添加新用户失败");
            System.err.println(e.getMessage());
        } finally {
            run();
        }
    }

    public void modifyUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要修改的用户名");
        String username = sc.nextLine();
        System.out.println("1.修改密码");
        System.out.println("2.修改邮箱");
        System.out.println("0.返回上一层");
        int num = sc.nextInt();
        if (num == 1) {
            System.out.print("新密码：");
            String newpassword = sc.nextLine();
            try {
                adminUserDao.modifyPassword(username, newpassword);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("修改密码失败");
                System.err.println(e.getMessage());
            } finally {
                run();
            }
        } else if (num == 2) {
            System.out.print("新邮箱：");
            String newemail = sc.nextLine();
            try {
                adminUserDao.modifyPassword(username, newemail);
            } catch (Exception e) {
                System.err.println("修改邮箱失败");
                System.err.println(e.getMessage());
            } finally {
                run();
            }

        }
    }

    public void userSyso() {
        System.out.println("-----------------------");
        System.out.println("1.查看当前所有用户信息");
        System.out.println("2.添加新的用户");
        System.out.println("3.修改用户信息");
        System.out.println("0.返回上一层");
        System.out.println("-----------------------");
    }
}
