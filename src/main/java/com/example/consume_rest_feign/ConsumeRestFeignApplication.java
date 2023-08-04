package com.example.consume_rest_feign;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;


@SpringBootApplication
@EnableFeignClients
public class ConsumeRestFeignApplication {

	Logger log = LogManager.getLogger(ConsumeRestFeignApplication.class);;

	@Autowired
	SongClient storeClient;

	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestFeignApplication.class, args);
	}
	@EventListener(ApplicationStartedEvent.class)
	public void makeRequest(){
		log.info(storeClient.getAllSongs());
		// Quote quote = new Quote("example type", new Value(33L, "example quote"));
		// log.info(" quota równa, " + quote);
		// log.info(storeClient.postQuote(quote));
		// log.info(storeClient.getQuoteById(33L));
		// storeClient.delete(21L);
		// log.info(storeClient.getAllQuotes());
	}
}
