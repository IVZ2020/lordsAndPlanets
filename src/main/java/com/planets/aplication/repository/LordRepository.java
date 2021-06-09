package com.planets.aplication.repository;

import com.planets.aplication.domain.Lord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LordRepository extends JpaRepository<Lord, Long> {

    Lord findByLordName (String name);
}
