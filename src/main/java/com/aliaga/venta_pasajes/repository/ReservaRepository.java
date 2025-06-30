package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Reserva;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends BaseRepository<Reserva, Long> {
}
