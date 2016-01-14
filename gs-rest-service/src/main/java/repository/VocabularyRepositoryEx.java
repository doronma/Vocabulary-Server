package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import beans.vocabulary.WordGroup;

public interface VocabularyRepositoryEx extends MongoRepository<WordGroup, String> {

	public List<WordGroup> findByGroupName(String groupName);

}