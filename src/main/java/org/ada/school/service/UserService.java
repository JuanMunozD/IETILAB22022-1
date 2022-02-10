package org.ada.school.service;

import java.util.Date;
import java.util.List;

import org.ada.school.model.UserDocument;

public interface UserService {

	UserDocument findById(String id);

	List<UserDocument> all();

	boolean deleteById(String id);

	UserDocument update(UserDocument user, String id);

	UserDocument create(UserDocument user);

	List<UserDocument> findAllByNameOrLastNameLike(String name, String lastName);

	List<UserDocument> findAllByCreatedAtAfter(Date startDate);
}
