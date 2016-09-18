package pl.dawydiuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawydiuk.model.Joke;
import pl.dawydiuk.model.User;
import pl.dawydiuk.service.JokeService;
import pl.dawydiuk.service.UserService;

import java.util.List;

/**
 * Created by Konrad on 13.09.2016.
 */
@RequestMapping(value = "jokes")
@RestController
public class JokeController {


    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping(value = "getAllJokes",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Joke>> getAllJokes(){
        List<Joke> allJokes = jokeService.getAllJokes();
        HttpStatus httpStatus = !allJokes.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<List<Joke>>(allJokes,httpStatus);
    }


    @PostMapping(value = "addJoke",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> addAndSaveJoke(@RequestBody Joke joke){
        jokeService.saveOrUpdateJoke(joke);
        HttpStatus httpStatus = joke !=null ? HttpStatus.CREATED : HttpStatus.CONFLICT;
        return new ResponseEntity<Joke>(httpStatus);
    }

    @DeleteMapping(value = "deleteJoke/{id}")
    public ResponseEntity<Joke> deleteJoke(@PathVariable Integer id){
        Joke joke = jokeService.findJokeById(id);
        HttpStatus httpStatus;
        if(joke!=null){
            jokeService.deleteJoke(id);
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<Joke>(httpStatus);
        }else {
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<Joke>(httpStatus);
        }
    }


    @GetMapping(value = "findJokeById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> findJokeById(@PathVariable Integer id){
        Joke joke = jokeService.findJokeById(id);
        HttpStatus httpStatus;
        if(joke!=null){
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<Joke>(joke,httpStatus);
        }else {
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<Joke>(httpStatus);
        }
    }


}
