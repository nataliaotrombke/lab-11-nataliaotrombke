package com.westeros.webapi.services;

import com.westeros.data.model.Movie;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{
    private final ICatalogData db;
    @Override
    public long saveMovie(MovieDto dto) {

        var movieEntity = new Movie();
        movieEntity.setRuntime(dto.runtime());
        movieEntity.setOverview(dto.overview());
        movieEntity.setReleaseDate(dto.releaseDate());
        movieEntity.setBudget(dto.budget());
        movieEntity.setOriginalTitle(dto.title());
        movieEntity.setHomepage(dto.homepage());
        movieEntity.setOriginalLanguage(dto.language());
        db.getMovies().save(movieEntity);
        return movieEntity.getId();
    }

    private MovieSummaryDto getMovieSummaryDto(Movie movie) {
        return new MovieSummaryDto(
                movie.getId(),
                movie.getOriginalLanguage(),
                movie.getOriginalTitle(),
                movie.getHomepage()
        );
    }

}
