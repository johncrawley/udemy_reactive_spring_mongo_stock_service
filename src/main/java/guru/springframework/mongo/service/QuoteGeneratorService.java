package guru.springframework.mongo.service;

import java.time.Duration;

import guru.springframework.mongo.model.Quote;
import reactor.core.publisher.Flux;

public interface QuoteGeneratorService {

	Flux<Quote> fetchQuoteStream(Duration period);
	
}
