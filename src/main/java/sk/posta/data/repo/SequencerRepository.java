package sk.posta.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import sk.posta.data.ConfigVersion;
import sk.posta.data.Sequencer;

public interface SequencerRepository extends MongoRepository<Sequencer, String> {
	public Sequencer findByDatum(Long datum);
}
