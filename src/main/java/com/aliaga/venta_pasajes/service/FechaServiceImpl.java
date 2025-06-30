package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Fecha;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.FechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FechaServiceImpl extends BaseServiceImpl<Fecha, Long> implements FechaService {

    @Autowired
    private FechaRepository fechaRepository;

    public FechaServiceImpl(BaseRepository<Fecha, Long> baseRepository) {
        super(baseRepository);
    }
}
