package sk.posta.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import sk.posta.data.Sluzba;
import sk.posta.data.Urad;

public interface SluzbaRepository extends MongoRepository<Sluzba, String>{

	Sluzba findByBusId(String id);
}
