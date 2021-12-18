package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.WritingCode;
import java.util.List;

public interface WritingCodeService {

    void create(WritingCode writingCode);

    List<WritingCode> readAll();

    WritingCode read(int id);

    boolean update(WritingCode writingCode, int id);

    boolean delete(int id);
}
