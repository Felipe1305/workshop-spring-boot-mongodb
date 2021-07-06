package org.serratec.api.workshopmongo.services;

import java.util.List;

import org.serratec.api.workshopmongo.domain.User;
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
}
