package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Ciudad;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends BaseRepository<Ciudad, String> {
}
