package ou.acs.repository;

import ou.acs.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
    User getUserByName(String name);
}
