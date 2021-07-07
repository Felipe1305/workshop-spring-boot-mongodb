package org.serratec.api.workshopmongo.repositories;

import java.util.List;

import org.serratec.api.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	@Query("{'title': {$regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String title);

}
