package ou.acs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ou.acs.entity.Person;
import ou.acs.repository.PersonRepository;

import java.io.IOException;
import java.util.List;

@Service
@PropertySource("application.properties")
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    @Value("${directory}")
    private String directory;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons(String userName) throws IOException {
        return  personRepository.getAllPersons(userName);
    }
}
