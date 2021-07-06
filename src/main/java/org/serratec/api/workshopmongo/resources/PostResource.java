package org.serratec.api.workshopmongo.resources;

import org.serratec.api.workshopmongo.domain.Post;
import org.serratec.api.workshopmongo.dto.UserDTO;
import org.serratec.api.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;


	
	@RequestMapping(value="/{id}", method= RequestMethod.GET) 
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	
	
	
}
