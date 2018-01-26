package com.abc;

import com.abc.profile.ProfileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class AbcApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AbcApiApplication.class, args);
	}

	@Autowired
	private ProfileRepository repository;

	@Override
	public void run(String... args) throws Exception {


	}

}
