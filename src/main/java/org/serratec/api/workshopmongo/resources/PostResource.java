package org.serratec.api.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.serratec.api.workshopmongo.domain.Post;
import org.serratec.api.workshopmongo.resources.utils.URL;
import org.serratec.api.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/titlesearch", method= RequestMethod.GET) 
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		return ResponseEntity.ok().body(posts);
	}
	
	@RequestMapping(value="/fullsearch", method= RequestMethod.GET) 
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate)
	
	{
		text = URL.decodeParam(text);
		Date min = URL.converteDate(minDate, new Date(0));
		System.out.println(min.toString());
		Date max = URL.converteDate(maxDate, new Date());
		System.out.println(max.toString());
		
		List<Post> posts = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(posts);
	}
	
	
	
	
}
