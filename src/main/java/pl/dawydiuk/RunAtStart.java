package pl.dawydiuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dawydiuk.dao.JokeRespository;
import pl.dawydiuk.dao.RoleRespository;
import pl.dawydiuk.dao.UserRespository;
import pl.dawydiuk.dao.VoteRespository;
import pl.dawydiuk.enums.EPlec;
import pl.dawydiuk.model.Joke;
import pl.dawydiuk.model.Role;
import pl.dawydiuk.model.User;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * Created by Konrad on 13.09.2016.
 */

@Component
public class RunAtStart {

    private UserRespository userRespository;
    private JokeRespository jokeRespository;
    private VoteRespository voteRespository;
    private RoleRespository roleRespository;

    @Autowired
    public RunAtStart(UserRespository userRespository, JokeRespository jokeRespository, VoteRespository voteRespository, RoleRespository roleRespository) {
        this.userRespository = userRespository;
        this.jokeRespository = jokeRespository;
        this.voteRespository = voteRespository;
        this.roleRespository = roleRespository;
    }


    //@PostConstruct
    public void runAtStart() {

//        User user = new User();
//        user.setLogin("davyd");
//        user.setEmail("davyd@wp.pl");
//        user.setPlec(EPlec.MEZCZYZNA);
//        user.setPassword("davyd");
//        userRespository.save(user);
//
//        User user1 = new User();
//        user1.setLogin("robin");
//        user1.setEmail("robin@wp.pl");
//        user1.setPlec(EPlec.MEZCZYZNA);
//        user1.setPassword("robin");
//        userRespository.save(user1);

//        User user2 = new User();
//        user2.setLogin("maki");
//        user2.setEmial("maki@wp.pl");
//        user2.setPlec(EPlec.MEZCZYZNA);
//        user2.setPassword("maki");


//        Role roleUser = new Role();
//        roleUser.setId(1);
//        roleUser.setCode("ROLE_USER");
//        roleUser.setLabel("User");
//
//        Role roleAdmin = new Role();
//        roleAdmin.setId(2);
//        roleAdmin.setCode("ROLE_ADMIN");
//        roleAdmin.setLabel("Admin");
//
//        roleRespository.save(roleUser);
//        roleRespository.save(roleAdmin);

//        Role one = roleRespository.findOne(1);
//        Role two = roleRespository.findOne(2);
//
//        User davyd = userRespository.findUserByLogin("davyd");
//        User robin = userRespository.findUserByLogin("robin");
//
//        davyd.getRoles().add(one);
//        davyd.getRoles().add(two);
//
//        robin.getRoles().add(one);
//
//        userRespository.save(davyd);
//        userRespository.save(robin);
//        User one = userRespository.findOne(3);
//        one.getRoles().add(roleRespository.findOne(1));
//        userRespository.save(one);

    }

}
