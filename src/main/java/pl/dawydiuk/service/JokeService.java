package pl.dawydiuk.service;

import pl.dawydiuk.model.Joke;

import java.util.List;

/**
 * Created by Konrad on 18.09.2016.
 */
public interface JokeService {

    List<Joke> getAllJokes();
    void saveOrUpdateJoke(Joke joke);
    void deleteJoke(Integer id);
    Joke findJokeById(Integer id);

}
