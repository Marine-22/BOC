package sk.posta.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sk.posta.data.Predpis;

@Repository
public interface PredpisRepository extends MongoRepository<Predpis, String> {
	Predpis findByIdPredpisu(String id);
}
