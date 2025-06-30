package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Pago;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl extends BaseServiceImpl<Pago, Long> implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public PagoServiceImpl(BaseRepository<Pago, Long> baseRepository) {
        super(baseRepository);
    }
}
