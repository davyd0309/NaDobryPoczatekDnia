package pl.dawydiuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawydiuk.dao.VoteRespository;
import pl.dawydiuk.model.Vote;

import java.util.List;

/**
 * Created by Konrad on 18.09.2016.
 */
@Service
public class VoteServiceImpl implements VoteService {


    private VoteRespository voteRespository;


    @Autowired
    public VoteServiceImpl(VoteRespository voteRespository) {
        this.voteRespository = voteRespository;
    }

    @Override
    public List<Vote> getAllVotes() {
        return (List<Vote>) voteRespository.findAll();
    }

    @Override
    public void saveOrUpdateVote(Vote vote) {
        voteRespository.save(vote);
    }

    @Override
    public void deleteVote(Integer id) {
        voteRespository.delete(id);
    }

    @Override
    public Vote findVoteById(Integer id) {
        return voteRespository.findOne(id);
    }
}
