package com.dd.covid;

import com.dd.covid.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication {

	public static void main(String[] args) {

		SpringApplication.run(CovidApplication.class, args);

	}

}
