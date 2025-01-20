package com.westeros.moviesclient;

import com.westeros.moviesclient.dto.PictureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MoviesPicturesClient implements IMoviesPicturesClient {

    private final RestTemplate restTemplate;
    private final String apiKey = "themoviedb_key";

    public MoviesPicturesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PictureDto> getPictures(int movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/images?api_key=" + apiKey;
        try {
            ResponseEntity<PictureDto[]> response = restTemplate.getForEntity(url, PictureDto[].class);
            return Arrays.asList(response.getBody());
        } catch (HttpClientErrorException e) {
            System.err.println("Error response from API: " + e.getResponseBodyAsString());

            if (e.getStatusCode().is4xxClientError()) {
                throw new RuntimeException("Invalid API key or unauthorized access: " + e.getResponseBodyAsString());
            }
            if (e.getStatusCode().is5xxServerError()) {
                throw new RuntimeException("Server error: " + e.getMessage());
            }

            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }
}