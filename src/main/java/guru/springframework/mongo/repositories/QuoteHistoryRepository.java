package guru.springframework.mongo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import guru.springframework.mongo.domain.QuoteHistory;

public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory, String> {

}
