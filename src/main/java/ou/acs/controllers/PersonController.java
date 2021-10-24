package ou.acs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ou.acs.entity.Person;
import ou.acs.service.PersonService;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping("/people")
@CrossOrigin
public class PersonController {
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{user}")
    public ResponseEntity<List<Person>> getPersons(@PathVariable("user") String user) throws IOException {
        return new ResponseEntity<>(personService.getAllPersons(user), HttpStatus.OK);
    }
}
