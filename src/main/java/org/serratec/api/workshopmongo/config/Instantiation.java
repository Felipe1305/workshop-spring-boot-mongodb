package org.serratec.api.workshopmongo.config;

import java.util.Arrays;

import org.serratec.api.workshopmongo.domain.User;
import org.serratec.api.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		
		userRepo.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepo.saveAll(Arrays.asList(maria,alex,bob));
	}

}
