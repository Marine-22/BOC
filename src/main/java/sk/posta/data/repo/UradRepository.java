package sk.posta.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import sk.posta.data.Urad;

public interface UradRepository extends MongoRepository<Urad, String>{
	public Urad findByBusId(String busId);
	public Urad findByName(String name);
}
