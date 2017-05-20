package com.sdust;

import com.sdust.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Propertymanager2Application implements CommandLineRunner{

	@Autowired private MainView mainView;

	public static void main(String[] args) {
		SpringApplication.run(Propertymanager2Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		mainView.run();
	}
}
