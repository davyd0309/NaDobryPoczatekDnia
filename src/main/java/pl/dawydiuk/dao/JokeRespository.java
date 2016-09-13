package pl.dawydiuk.dao;

import org.springframework.data.repository.CrudRepository;
import pl.dawydiuk.model.Joke;
import pl.dawydiuk.model.User;

/**
 * Created by Konrad on 13.09.2016.
 */
public interface JokeRespository extends CrudRepository<Joke,Integer> {
    

}
