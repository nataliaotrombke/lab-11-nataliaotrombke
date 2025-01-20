package com.westeros.webapi;

import com.westeros.data.model.Picture;
import com.westeros.data.repositories.PicturesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pictures")
public class MoviesPicturesController {

    private final PicturesRepository picturesRepository;

    public MoviesPicturesController(PicturesRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }

    @GetMapping("/{movieId}")
    public List<Picture> getPictures(@PathVariable Long movieId) {
        return picturesRepository.findAll();
    }
}