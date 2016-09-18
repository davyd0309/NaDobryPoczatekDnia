package pl.dawydiuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dawydiuk.model.Joke;
import pl.dawydiuk.model.Vote;
import pl.dawydiuk.service.JokeService;
import pl.dawydiuk.service.VoteService;

import java.util.List;

/**
 * Created by Konrad on 13.09.2016.
 */
@RequestMapping(value = "votes")
@RestController
public class VoteController {


    private VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping(value = "getAllVotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vote>> getAllVotes(){
        List<Vote> allVotes = voteService.getAllVotes();
        HttpStatus httpStatus = !allVotes.isEmpty() ? HttpStatus.OK : HttpStatus.NO_CONTENT;
        return new ResponseEntity<List<Vote>>(allVotes,httpStatus);
    }


    @PostMapping(value = "addVote",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> addAndSaveVote(@RequestBody Vote vote){
        voteService.saveOrUpdateVote(vote);
        HttpStatus httpStatus = vote !=null ? HttpStatus.CREATED : HttpStatus.CONFLICT;
        return new ResponseEntity<Vote>(httpStatus);
    }

    @DeleteMapping(value = "deleteVote/{id}")
    public ResponseEntity<Vote> deleteVote(@PathVariable Integer id){
        Vote vote = voteService.findVoteById(id);
        HttpStatus httpStatus;
        if(vote!=null){
            voteService.deleteVote(id);
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<Vote>(httpStatus);
        }else {
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<Vote>(httpStatus);
        }
    }


    @GetMapping(value = "findVoteById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> findVoteById(@PathVariable Integer id){
        Vote vote = voteService.findVoteById(id);
        HttpStatus httpStatus;
        if(vote!=null){
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<Vote>(vote,httpStatus);
        }else {
            httpStatus = HttpStatus.NOT_FOUND;
            return new ResponseEntity<Vote>(httpStatus);
        }
    }


}
