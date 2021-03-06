package sk.posta.data.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sk.posta.data.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public User findByIdZamLogin(String idZamLogin);
	
}
