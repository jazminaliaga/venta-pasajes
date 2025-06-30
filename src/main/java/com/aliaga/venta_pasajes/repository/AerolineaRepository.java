package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Aerolinea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AerolineaRepository extends BaseRepository<Aerolinea, String> {

    @Query("SELECT DISTINCT v.aerolinea FROM Vuelo v JOIN v.aeropuertos a WHERE a.nombreAeropuerto = :nombreAeropuerto")
    List<Aerolinea> findAerolíneasPorAeropuerto(@Param("nombreAeropuerto") String nombreAeropuerto);
}
