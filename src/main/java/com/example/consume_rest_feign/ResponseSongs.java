package com.example.consume_rest_feign;

import java.util.Map;

public record ResponseSongs(Map<Integer, Song> songs) {
    
}
