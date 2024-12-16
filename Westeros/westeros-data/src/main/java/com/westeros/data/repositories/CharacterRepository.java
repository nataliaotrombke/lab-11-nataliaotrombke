package com.westeros.data.repositories;

import com.westeros.data.model.ActorRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<ActorRole, Long> {
}
