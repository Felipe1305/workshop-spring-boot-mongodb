package org.serratec.api.workshopmongo.services;

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
		return repo.findByTitleContainingIgnoreCase(text);
	}
	

	

}
