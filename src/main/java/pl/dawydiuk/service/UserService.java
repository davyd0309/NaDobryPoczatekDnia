package pl.dawydiuk.service;

import pl.dawydiuk.model.User;

import java.util.List;

/**
 * Created by Konrad on 13.09.2016.
 */
public interface UserService {

    List<User> getAllUsers();
    void saveOrUpdateUser(User user);
    void deleteUser(Integer id);
    User findUserById(Integer id);
    User findUserByLogin(String login);

}
