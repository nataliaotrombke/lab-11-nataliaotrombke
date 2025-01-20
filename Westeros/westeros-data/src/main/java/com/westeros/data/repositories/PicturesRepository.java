package com.westeros.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.westeros.data.model.Picture;

import java.util.Optional;
import java.util.UUID;

public interface PicturesRepository extends JpaRepository<Picture, Long> {
    Optional<Picture> findByUuid(UUID uuid);
}