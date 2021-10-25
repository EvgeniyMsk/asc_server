package ou.acs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ou.acs.entity.Person;
import ou.acs.service.PersonService;
import ou.acs.service.UserService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController()
@RequestMapping("/api/people")
@CrossOrigin
public class PersonController {
    PersonService personService;
    UserService userService;

    @Autowired
    public PersonController(PersonService personService, UserService userService) {
        this.personService = personService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Object> getPersons(Principal principal) throws IOException {
        try {
            if (principal.getName().equals("admin"))
                return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
            return new ResponseEntity<>(getAllPersonsByPrincipal(principal), HttpStatus.OK);
        }
        catch (IOException e) {
            return new ResponseEntity<>("Такой страницы не существует!", HttpStatus.NOT_FOUND);
        }
    }

    private List<Person> getAllPersonsByPrincipal(Principal principal) throws IOException {
        String username = principal.getName();
        try {
            return personService.getAllPersons(username);
        }
        catch (IOException e) {
            throw new UsernameNotFoundException("Username not found with username " + username);
        }
    }
}
