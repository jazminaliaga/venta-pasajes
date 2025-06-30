package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Avion;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends BaseRepository<Avion, Long> {
}
