package pl.dawydiuk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dawydiuk.dao.JokeRespository;
import pl.dawydiuk.dao.UserRespository;
import pl.dawydiuk.dao.VoteRespository;
import pl.dawydiuk.model.Joke;
import pl.dawydiuk.model.User;

import javax.annotation.PostConstruct;

/**
 * Created by Konrad on 13.09.2016.
 */

@Component
public class RunAtStart {

    private UserRespository userRespository;
    private JokeRespository jokeRespository;
    private VoteRespository voteRespository;

    @Autowired
    public RunAtStart(UserRespository userRespository, JokeRespository jokeRespository, VoteRespository voteRespository) {
        this.userRespository = userRespository;
        this.jokeRespository = jokeRespository;
        this.voteRespository = voteRespository;
    }


    //@PostConstruct
    public void runAtStart() {

        User user = new User();
        user.setLogin("davyd");
        user.setEmial("davyd@wp.pl");
        user.setPassword("davyd");

        User user1 = new User();
        user1.setLogin("robin");
        user1.setEmial("robin@wp.pl");
        user1.setPassword("robin");

        User user2 = new User();
        user2.setLogin("maki");
        user2.setEmial("maki@wp.pl");
        user2.setPassword("maki");

        userRespository.save(user);
        userRespository.save(user1);
        userRespository.save(user2);

    }

}
