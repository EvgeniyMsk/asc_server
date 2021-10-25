package ou.acs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ou.acs.entity.User;
import ou.acs.entity.roles.ERole;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@PropertySource("application.properties")
public class UserRepositoryImpl implements UserRepository {
    @Value("${directory}")
    private String directoryPath;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        File fileDir = new File(directoryPath);
        for (File file : fileDir.listFiles())
        {
            Set<ERole> roles = new HashSet<>();
            roles.add(ERole.USER);
            result.add(new User(file.getName().substring(0, file.getName().indexOf(".")), passwordEncoder.encode("password"), roles));
        }
        Set<ERole> roles = new HashSet<>();
        roles.add(ERole.ADMIN);
        result.add(new User("admin", passwordEncoder.encode("pass"), roles));
        return result;
    }

    @Override
    public User getUserByName(String name) {
        for (User user : getAllUsers())
            if (user.getUsername().equals(name))
                return user;
        return null;
    }
}
