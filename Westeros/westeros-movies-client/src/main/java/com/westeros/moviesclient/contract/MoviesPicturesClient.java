package com.westeros.moviesclient.contract;

import com.westeros.moviesclient.IMoviesPicturesClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class MoviesPicturesClient implements IMoviesPicturesClient {

    private final RestTemplate restTemplate;
    private final String apiKey = "your_api_key";

    public MoviesPicturesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <PictureDto> List<PictureDto> getPictures(int movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/images?api_key=" + apiKey;
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url, PictureDto[].class)));
    }
}