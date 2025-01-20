package com.westeros.moviesclient;

import java.util.List;

public interface IMoviesPicturesClient {
    <PictureDto> List<PictureDto> getPictures(int movieId);
}