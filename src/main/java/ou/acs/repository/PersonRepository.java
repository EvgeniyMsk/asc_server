package ou.acs.repository;

import ou.acs.entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonRepository {
    List<Person> getAllPersons(String userName) throws IOException;
}
