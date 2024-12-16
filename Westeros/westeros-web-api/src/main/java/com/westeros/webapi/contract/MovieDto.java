package com.westeros.webapi.contract;

import java.time.LocalDate;

public record MovieDto (long id,
                        String title,
                        String homepage,
                        String language,
                        boolean adult,
                        int budget,
                        String overview,
                        LocalDate releaseDate,
                        int runtime){}
