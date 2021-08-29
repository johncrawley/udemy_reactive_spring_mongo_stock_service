package guru.springframework.mongo.service;

import java.time.Duration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor	
public class QuoteRunner implements CommandLineRunner {
	
	private final QuoteGeneratorService quoteGeneratorService;
	private final QuoteHistoryService quoteHistoryService;
	
	@Override
	public void run(String ...args) throws Exception {
		quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(300l))
		.take(50)
		.log("got Quote:")
		.flatMap(quoteHistoryService::saveQuoteToMongo)
		.subscribe(savedQuote -> {
			log.debug("Saved Quote: " + savedQuote);
		}, throwable -> {
			log.error("some Error", throwable);
		}, () -> {
			log.debug("all done!!!");
		});
	}

}
