package pl.dawydiuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dawydiuk.dao.UserRespository;
import pl.dawydiuk.model.User;

import java.util.List;

/**
 * Created by Konrad on 13.09.2016.
 */
public class UserServiceImpl implements UserService{


    private UserRespository userRespository;


    @Autowired
    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRespository.findAll();
    }

    @Override
    public void saveOrUpdateUser(User user) {
        userRespository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRespository.delete(id);
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }
}
