package org.serratec.api.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.serratec.api.workshopmongo.domain.Post;
import org.serratec.api.workshopmongo.domain.User;
import org.serratec.api.workshopmongo.dto.AuthorDTO;
import org.serratec.api.workshopmongo.dto.ComentDTO;
import org.serratec.api.workshopmongo.repositories.PostRepository;
import org.serratec.api.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	@Autowired
	PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepo.deleteAll();
		postRepo.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepo.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria));
		
		ComentDTO c1 = new ComentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		ComentDTO c2 = new ComentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		ComentDTO c3 = new ComentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		
		post1.getComents().addAll(Arrays.asList(c1,c2));
		post2.getComents().addAll(Arrays.asList(c3));
		
		

		postRepo.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepo.save(maria);
		
		
	}

}
