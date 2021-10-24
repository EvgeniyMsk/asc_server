package ou.acs.service;

import ou.acs.entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonService {
    List<Person> getAllPersons(String userName) throws IOException;
}
