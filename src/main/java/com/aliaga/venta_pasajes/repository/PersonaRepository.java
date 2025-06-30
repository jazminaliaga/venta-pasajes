package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
