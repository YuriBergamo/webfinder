package br.com.odontoresearch.webfinder.repository;

import br.com.odontoresearch.webfinder.data.UserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDomain, String>{

}
