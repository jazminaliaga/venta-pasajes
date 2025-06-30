package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends BaseRepository<Vuelo, Long> {

    @Query("SELECT DISTINCT v FROM Vuelo v " +
            "LEFT JOIN FETCH v.aeropuertos a " +
            "LEFT JOIN FETCH a.ciudad c " +
            "LEFT JOIN FETCH v.aerolinea al")
    List<Vuelo> findAllWithAeropuertosAndCiudad();

    @Query("SELECT v FROM Vuelo v " +
            "LEFT JOIN FETCH v.aeropuertos a " +
            "LEFT JOIN FETCH a.ciudad c " +
            "LEFT JOIN FETCH v.aerolinea al " +
            "WHERE v.aerolinea.nombreAerolinea = :aerolinea")
    List<Vuelo> findByAerolineaWithAeropuertosAndCiudad(@Param("aerolinea") String aerolinea);

}
