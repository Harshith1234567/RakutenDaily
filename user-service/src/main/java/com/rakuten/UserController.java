package com.rakuten;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService service; // only reference

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) // set response code to 201
	Integer saveUser(@Valid @RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		return service.save(user);
		
	}

	@GetMapping 
	List<User> getUsers() {
		return service.getAllUsers();
	}

//
	@GetMapping("/{name}")
	List<User> getUsersByName(@PathVariable String name) {
		System.out.println(name);
		return service.getUserByName(name);
	}

	@GetMapping("/age/{age}") 
	List<User> getUsersByage(@PathVariable int age) {

		List<User> filteredUsers = service.getUserByAge(age);
		return filteredUsers;
	}
	
	
	@DeleteMapping("/{id}")
	private void deleteUser(@PathVariable int id) {
		repository.deleteByID(id);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error-> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = ((FieldError) error).getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
}
