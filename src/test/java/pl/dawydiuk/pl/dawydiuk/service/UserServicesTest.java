package pl.dawydiuk.pl.dawydiuk.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.dawydiuk.AbstractTest;
import pl.dawydiuk.model.User;
import pl.dawydiuk.service.UserService;


import java.util.List;

/**
 * Created by Konrad on 02.10.2016.
 */
@Transactional
public class UserServicesTest extends AbstractTest {

    @Autowired
    private UserService userService;

    private Integer userId = 3;

    @Test
    public void testGetdAllUsers(){
        List<User> allUsers = userService.getAllUsers();
            Assert.assertNotNull("Failure - list should not be empty",allUsers);
    }

    @Test
    public void testFindUserById(){

        User userById = userService.findUserById(userId);
        Assert.assertNotNull("Failure - user should not be NULL",userById);
        Assert.assertEquals("Failure - find user should have id"+userId,userId,userById.getId());
    }

    @Test
    public void testNotFindUserById(){
        Integer id = Integer.MAX_VALUE;
        User userById = userService.findUserById(id);
        Assert.assertNull("Failure - user should be NULL",userById);

    }

    @Test
    public void saveOrUpdateUser(){
        User user = new User();
        user.setLogin("testLogin");
        user.setPassword("testPassword");
        user.setEmial("testEmail");

        userService.saveOrUpdateUser(user);

        Assert.assertNotNull("Failure - user should not be a NULL",user);
        Assert.assertEquals("Failure - user have different login","testLogin",user.getLogin());
        Assert.assertEquals("Failure - user should have different password ","testPassword",user.getPassword());
        Assert.assertEquals("Failure - user should have different email ","testEmail",user.getEmial());
    }

    @Test
    public void deleteUser(){

        User userById = userService.findUserById(userId);
        Assert.assertNotNull("Failure - user should not be NULL",userById);

        Integer id = userById.getId();
        userService.deleteUser(id);

        User userById1 = userService.findUserById(id);

        Assert.assertNull("Failure - user should be NULL",userById1);
    }

}
