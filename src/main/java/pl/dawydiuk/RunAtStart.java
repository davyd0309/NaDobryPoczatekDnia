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


   // @PostConstruct
    public void runAtStart() {

        User user = new User();
        user.setLogin("davyd");
        user.setEmial("davyd@wp.pl");
        user.setPassword("davyd");

        userRespository.save(user);

    }

}
