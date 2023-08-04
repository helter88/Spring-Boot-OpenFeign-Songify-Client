package com.example.consume_rest_feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value ="stores", url="http://localhost:8085")
public interface SongClient {

    @RequestMapping(method = RequestMethod.GET, value = "/songs")
    ResponseSongs getAllSongs();

    @RequestMapping(method = RequestMethod.GET, value = "/songs/{id}")
    SingleSong getSongById(@PathVariable Integer id);

    @PostMapping(path = "/songs")
    SingleSong postSong(@RequestBody Song song);

    @DeleteMapping(path = "/songs/{id}")
    void deleteSong(@PathVariable Integer id);

    @PutMapping(path = "/songs/{id}")
    void updateSong(@PathVariable Integer id, @RequestBody Song song);

}
