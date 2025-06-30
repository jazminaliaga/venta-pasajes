package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Aeropuerto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AeropuertoRepository extends BaseRepository<Aeropuerto, String> {

    @Query("SELECT a FROM Aeropuerto a WHERE a.ciudad.nombreCiudad = :nombreCiudad")
    List<Aeropuerto> findByCiudad(@Param("nombreCiudad") String nombreCiudad);

}
