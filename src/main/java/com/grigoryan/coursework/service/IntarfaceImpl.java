package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.Intarface;
import com.grigoryan.coursework.repository.IntarfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntarfaceImpl implements IntarfaceService {

    @Autowired
    private IntarfaceRepository intarfaceRepository;

    @Override
    public void create(Intarface intarface) {
        intarfaceRepository.save(intarface);
    }

    @Override
    public List<Intarface> readAll() {
        return intarfaceRepository.findAll();
    }

    @Override
    public Intarface read(int id) {
        return intarfaceRepository.getOne(id);
    }

    @Override
    public boolean update(Intarface intarface, int id) {
        if(intarfaceRepository.existsById(id)) {
            intarface.setId(id);
            intarfaceRepository.save(intarface);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (intarfaceRepository.existsById(id)){
            intarfaceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
