package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Tarifa;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends BaseRepository<Tarifa, Long> {
}
