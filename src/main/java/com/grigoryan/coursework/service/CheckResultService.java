package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.CheckResult;

import java.util.List;

public interface CheckResultService {

    void create(CheckResult checkResult);

    List<CheckResult> readAll();

    CheckResult read(int id);

    boolean update(CheckResult checkResult, int id);

    boolean delete(int id);
}
