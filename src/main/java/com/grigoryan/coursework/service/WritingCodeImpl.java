package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.WritingCode;
import com.grigoryan.coursework.repository.WritingCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WritingCodeImpl implements WritingCodeService{

    @Autowired
    private WritingCodeRepository writingCodeRepository;

    @Override
    public void create(WritingCode writingCode) {
        writingCodeRepository.save(writingCode);
    }

    @Override
    public List<WritingCode> readAll() {
        return writingCodeRepository.findAll();
    }

    @Override
    public WritingCode read(int id) {
        return writingCodeRepository.getOne(id);
    }

    @Override
    public boolean update(WritingCode writingCode, int id) {
        if(writingCodeRepository.existsById(id)) {
            writingCode.setDependenciesId(id);
            writingCodeRepository.save(writingCode);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (writingCodeRepository.existsById(id)){
            writingCodeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
