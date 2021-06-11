package br.com.springboot.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.api.model.Users;
import br.com.springboot.api.repository.UsersRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired
	private UsersRepository usersRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
    	
    	Users users = new Users();
    	users.setName(name);
    	
    	usersRepository.save(users);
        return "Hello " + name + "!";
    }
    
    @GetMapping(value = "listAll")
    @ResponseBody
    public ResponseEntity<List<Users>> listUsers() {
    	
    	List<Users> users = usersRepository.findAll();
    	
    	return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
		
	}
    
    @PostMapping(value = "saveUsers")
    @ResponseBody
    public ResponseEntity<Users> saveUsers(@RequestBody Users users) {
    	Users user = usersRepository.save(users);
    	return new ResponseEntity<Users>(user, HttpStatus.CREATED);
    	
    }
}
