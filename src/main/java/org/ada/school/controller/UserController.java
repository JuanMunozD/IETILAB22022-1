package org.ada.school.controller;

import org.ada.school.dto.UserDto;
import org.ada.school.model.UserDocument;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(@Autowired UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDocument>> all() {
		return ResponseEntity.ok(userService.all());
	}

	@GetMapping("/filter/findByName")
	public ResponseEntity<List<UserDocument>> findAllByNameOrLastNameLike(@RequestParam String name,
			@RequestParam String lastName) {

		return ResponseEntity.ok(userService.findAllByNameOrLastNameLike(name, lastName));
	}

	@GetMapping("/filter/startDate")
	public ResponseEntity<List<UserDocument>> findAllByCreatedAtAfter(@RequestParam String startDate) {
		@SuppressWarnings("deprecation")
		Date newDate = new Date(startDate);
		return ResponseEntity.ok(userService.findAllByCreatedAtAfter(newDate));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDocument> findById(@PathVariable String id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@PostMapping
	public ResponseEntity<UserDocument> create(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(userService.create(new UserDocument(userDto)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDocument> update(@RequestBody UserDto userDto, @PathVariable String id) {
		return ResponseEntity.ok(userService.update(new UserDocument(userDto, id), id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {
		return ResponseEntity.ok(userService.deleteById(id));
	}

}
