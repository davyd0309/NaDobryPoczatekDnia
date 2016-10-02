package pl.dawydiuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dawydiuk.dao.JokeRespository;
import pl.dawydiuk.model.Joke;


import java.util.List;

/**
 * Created by Konrad on 18.09.2016.
 */
@Service
@Transactional
public class JokeServiceImpl implements JokeService {


    private JokeRespository jokeRespository;

    @Autowired
    public JokeServiceImpl(JokeRespository jokeRespository) {
        this.jokeRespository = jokeRespository;
    }

    @Override
    public List<Joke> getAllJokes() {
        return (List<Joke>) jokeRespository.findAll();
    }

    @Override
    public void saveOrUpdateJoke(Joke joke) {
        jokeRespository.save(joke);
    }

    @Override
    public void deleteJoke(Integer id) {
        jokeRespository.delete(id);
    }

    @Override
    public Joke findJokeById(Integer id) {
        return jokeRespository.findOne(id);
    }
}
