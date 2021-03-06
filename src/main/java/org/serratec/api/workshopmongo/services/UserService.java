package org.serratec.api.workshopmongo.services;

import java.util.List;

import org.serratec.api.workshopmongo.domain.User;
import org.serratec.api.workshopmongo.dto.UserDTO;
import org.serratec.api.workshopmongo.exception.ObjectNotFoundException;
import org.serratec.api.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		List<User> list = repo.findAll();
		return list;
	}

	public User findById(String id) {
		User user = repo.findById(id).orElseThrow( ()-> new ObjectNotFoundException("Objeto não encontrado"));
		return user;
	}
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	public User update(User obj) {
		findById(obj.getId());
		User user = repo.findById(obj.getId()).get();
		updateData(user, obj);
		return repo.save(user);
		
	}
	
	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	

}
