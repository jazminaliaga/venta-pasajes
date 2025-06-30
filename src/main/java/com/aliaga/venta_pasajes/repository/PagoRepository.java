package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Pago;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends BaseRepository<Pago, Long> {
}
