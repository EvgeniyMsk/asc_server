package ou.acs.service;

import ou.acs.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserByUserName(String userName);
}
