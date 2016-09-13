package pl.dawydiuk.dao;

import org.springframework.data.repository.CrudRepository;
import pl.dawydiuk.model.User;
import pl.dawydiuk.model.Vote;

/**
 * Created by Konrad on 13.09.2016.
 */
public interface VoteRespository extends CrudRepository<Vote,Integer> {


}
