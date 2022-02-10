package org.ada.school.service;

import java.util.Date;
import java.util.List;

import org.ada.school.model.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMongoDB implements UserService {

	private final UserRepository userRepository;

	public UserServiceMongoDB(@Autowired UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDocument create(UserDocument user) {
		return this.userRepository.save(user);
	}

	@Override
	public UserDocument findById(String id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public List<UserDocument> all() {
		return this.userRepository.findAll();
	}

	@Override
	public boolean deleteById(String id) {
		this.userRepository.deleteById(id);
		return this.userRepository.existsById(id);
	}

	@Override
	public UserDocument update(UserDocument user, String id) {

		if (this.userRepository.existsById(id)) {
			UserDocument oldUser = this.userRepository.findById(id).get();
			user.setId(id);
			user.setCreatedAt(oldUser.getCreatedAt());
		}
		;

		return this.userRepository.save(user);
	}

	@Override
	public List<UserDocument> findAllByNameOrLastNameLike(String name, String lastName) {
		// TODO Auto-generated method stub
		return this.userRepository.findAllByNameOrLastNameLike(name, lastName);
	}

	@Override
	public List<UserDocument> findAllByCreatedAtAfter(Date startDate) {
		// TODO Auto-generated method stub
		return this.userRepository.findAllByCreatedAtAfter(startDate);
	}
}