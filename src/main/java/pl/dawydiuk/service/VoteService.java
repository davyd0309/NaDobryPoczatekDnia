package pl.dawydiuk.service;

import pl.dawydiuk.model.Joke;
import pl.dawydiuk.model.Vote;

import java.util.List;

/**
 * Created by Konrad on 18.09.2016.
 */
public interface VoteService {

    List<Vote> getAllVotes();
    void saveOrUpdateVote(Vote vote);
    void deleteVote(Integer id);
    Vote findVoteById(Integer id);

}
