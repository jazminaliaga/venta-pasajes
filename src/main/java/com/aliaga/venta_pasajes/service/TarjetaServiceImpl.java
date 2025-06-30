package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Tarjeta;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl extends BaseServiceImpl<Tarjeta, Long> implements TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    public TarjetaServiceImpl(BaseRepository<Tarjeta, Long> baseRepository) {
        super(baseRepository);
    }
}
