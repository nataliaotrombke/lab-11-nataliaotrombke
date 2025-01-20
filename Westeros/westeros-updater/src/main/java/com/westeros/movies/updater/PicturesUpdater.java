package com.westeros.movies.updater;

import com.westeros.data.repositories.PicturesRepository;
import com.westeros.moviesclient.IMoviesPicturesClient;
import org.springframework.stereotype.Service;

@Service
public class PicturesUpdater implements IUpdatePictures {

    private final PicturesRepository picturesRepository;
    private final IMoviesPicturesClient moviesPicturesClient;

    public PicturesUpdater(PicturesRepository picturesRepository, IMoviesPicturesClient moviesPicturesClient) {
        this.picturesRepository = picturesRepository;
        this.moviesPicturesClient = moviesPicturesClient;
    }

    @Override
    public void updatePictures() {
    }
}