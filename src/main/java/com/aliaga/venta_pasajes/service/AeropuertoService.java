package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Aeropuerto;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AeropuertoService extends BaseServiceImpl<Aeropuerto, String> {

    @Autowired
    public AeropuertoService(BaseRepository<Aeropuerto, String> baseRepository) {
        super(baseRepository);
    }
}
