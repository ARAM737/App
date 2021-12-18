package com.grigoryan.coursework.service;

import com.grigoryan.coursework.entity.Intarface;

import java.util.List;

public interface IntarfaceService {
    void create(Intarface intarface);

    List<Intarface> readAll();

    Intarface read(int id);

    boolean update(Intarface intarface, int id);

    boolean delete(int id);
}
