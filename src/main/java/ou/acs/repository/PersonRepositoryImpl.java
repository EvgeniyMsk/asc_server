package ou.acs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ou.acs.entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Value("${directory}")
    private String directoryPath;

    @Override
    public List<Person> getAllPersons(String userName) throws IOException {
        List<Person> people = new ArrayList<>();
        File fileDir = new File(directoryPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir + "/" + userName + ".csv"), "Windows-1251"));
        reader.readLine();
        while (reader.ready())
            try {
                String line = reader.readLine();
                String[] data = line.split(";");
                people.add(new Person(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7],
                        data[8]
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
        String[] data = {"", "","","","","","","", "",};
        Person person = new Person(
                data[0],
                data[1],
                data[2],
                data[3],
                data[4],
                data[5],
                data[6],
                data[7],
                data[8]
        );
        return people;
    }
}
