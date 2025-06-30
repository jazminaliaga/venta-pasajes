package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Tarjeta;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends BaseRepository<Tarjeta, Long> {
}
