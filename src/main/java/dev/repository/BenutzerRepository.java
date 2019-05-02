package dev.repository;

import dev.model.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenutzerRepository extends JpaRepository<Benutzer, Integer> {
    Benutzer findByid(int id);
}
