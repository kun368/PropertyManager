package com.sdust;

import com.sdust.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Propertymanager2Application implements CommandLineRunner{

	@Autowired private MainView mainView;

	public static void main(String[] args) {
		SpringApplication.run(Propertymanager2Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.err.println("欢迎使用小区物业管理系统！");
		System.err.println("请选择下述功能，并输入功能序号使用！");
		System.out.println("请先登录！");
		try {
            mainView.run();
        } catch (Exception e) {
            System.err.println("操作有误，小区物业管理系统退出...");
        }
	}
}
