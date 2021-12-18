package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.BotFunction;
import com.grigoryan.coursework.repository.BotFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotFunctionImpl implements BotFunctionService {

    @Autowired
    private BotFunctionRepository botFunctionRepository;

    @Override
    public void create(BotFunction botFunction) {
        botFunctionRepository.save(botFunction);
    }

    @Override
    public List<BotFunction> readAll() {
        return botFunctionRepository.findAll();
    }

    @Override
    public BotFunction read(int id) {
       return botFunctionRepository.getOne(id);
    }

    @Override
    public boolean update(BotFunction botFunction, int id) {
        if(botFunctionRepository.existsById(id)) {
            botFunction.setCityId(id);
            botFunctionRepository.save(botFunction);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (botFunctionRepository.existsById(id)){
            botFunctionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
