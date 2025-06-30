package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Avion;
import com.aliaga.venta_pasajes.repository.AvionRepository;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionServiceImpl extends BaseServiceImpl<Avion, Long> implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    public AvionServiceImpl(BaseRepository<Avion, Long> baseRepository) {
        super(baseRepository);
    }
}
