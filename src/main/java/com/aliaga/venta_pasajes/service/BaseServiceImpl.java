package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.repository.BaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BaseServiceImpl<E, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<E> findAll() throws Exception {
        return baseRepository.findAll();
    }

    @Override
    public E findById(ID id) throws Exception {
        return baseRepository.findById(id).orElseThrow(() -> new Exception("Entity not found"));
    }

    @Override
    public E save(E entity) throws Exception {
        return baseRepository.save(entity);
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        if (!baseRepository.existsById(id)) {
            throw new Exception("Entity not found");
        }
        return baseRepository.save(entity);
    }

    @Override
    public boolean delete(ID id) throws Exception {
        if (!baseRepository.existsById(id)) {
            return false;
        }
        baseRepository.deleteById(id);
        return true;
    }
}
