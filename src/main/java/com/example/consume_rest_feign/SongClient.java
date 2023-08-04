package com.example.consume_rest_feign;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value ="stores", url="http://localhost:8080")
public interface SongClient {

    @RequestMapping(method = RequestMethod.GET, value = "/songs")
    ResponseSongs getAllSongs();

    @RequestMapping(method = RequestMethod.GET, value = "/api/{id}")
    Quote getQuoteById(@PathVariable Long id);

    @PostMapping(path = "/api/quote")
    Quote postQuote(@RequestBody Quote quote);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/quote/{id}")
    void delete(@PathVariable Long id);

}
