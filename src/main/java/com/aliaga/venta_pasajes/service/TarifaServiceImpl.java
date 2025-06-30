package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Tarifa;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarifaServiceImpl extends BaseServiceImpl<Tarifa, Long> implements TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    public TarifaServiceImpl(BaseRepository<Tarifa, Long> baseRepository) {
        super(baseRepository);
    }
}
