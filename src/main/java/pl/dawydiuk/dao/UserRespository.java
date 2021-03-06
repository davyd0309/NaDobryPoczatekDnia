package pl.dawydiuk.dao;

import org.springframework.data.repository.CrudRepository;
import pl.dawydiuk.model.User;

/**
 * Created by Konrad on 13.09.2016.
 */
public interface UserRespository extends CrudRepository<User,Integer> {

User findUserByLogin(String login);
}
