package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.BotFunction;

import java.util.List;

public interface BotFunctionService {
    void create(BotFunction botFunction);

    List<BotFunction> readAll();

    BotFunction read(int id);

    boolean update(BotFunction botFunction, int id);

    boolean delete(int id);
}
