package org.serratec.api.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.serratec.api.workshopmongo.domain.Post;
import org.serratec.api.workshopmongo.exception.ObjectNotFoundException;
import org.serratec.api.workshopmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;



	public Post findById(String id) {
		Post post = repo.findById(id).orElseThrow( ()-> new ObjectNotFoundException("Objeto não encontrado"));
		return post;
	}
	
	public List<Post> findByTitle(String text) {
		return repo.findByTitle(text);
	}
	

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime()+(24*60*60*100));
		return repo.fullSearch(text, minDate, maxDate);
	}
	

	

}
