package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Asiento;
import com.aliaga.venta_pasajes.repository.AsientoRepository;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImpl extends BaseServiceImpl<Asiento, Long> implements AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    public AsientoServiceImpl(AsientoRepository asientoRepository) {
        super(asientoRepository);
        this.asientoRepository = asientoRepository;
    }
}
