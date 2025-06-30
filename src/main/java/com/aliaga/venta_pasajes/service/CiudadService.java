package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Ciudad;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadService extends BaseServiceImpl<Ciudad, String> {

    @Autowired
    public CiudadService(BaseRepository<Ciudad, String> baseRepository) {
        super(baseRepository);
    }
}
