package sk.posta.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import sk.posta.data.ConfigVersion;

public interface ConfigVersionRepository extends MongoRepository<ConfigVersion, String> {
	public ConfigVersion findByName(String name);
}
