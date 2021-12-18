package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.CheckResult;
import com.grigoryan.coursework.repository.CheckResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckResultImpl implements CheckResultService{

    @Autowired
    private CheckResultRepository checkResultRepository;

    @Override
    public void create(CheckResult checkResult) {
        checkResultRepository.save(checkResult);
    }

    @Override
    public List<CheckResult> readAll() {
        return checkResultRepository.findAll();
    }

    @Override
    public CheckResult read(int id) {
        return checkResultRepository.getOne(id);
    }

    @Override
    public boolean update(CheckResult checkResult, int id) {
        if(checkResultRepository.existsById(id)) {
            checkResult.setTestId(id);
            checkResultRepository.save(checkResult);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (checkResultRepository.existsById(id)){
            checkResultRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
