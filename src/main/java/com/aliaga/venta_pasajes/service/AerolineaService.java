package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Aerolinea;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AerolineaService extends BaseServiceImpl<Aerolinea, String> {

    @Autowired
    public AerolineaService(BaseRepository<Aerolinea, String> baseRepository) {
        super(baseRepository);
    }
}
