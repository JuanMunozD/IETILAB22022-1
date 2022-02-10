package org.ada.school.repository;

import java.util.Date;
import java.util.List;

import org.ada.school.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {

	List<UserDocument> findAllByNameOrLastNameLike(String name, String lastName);

	List<UserDocument> findAllByCreatedAtAfter(Date startDate);
}