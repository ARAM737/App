package com.grigoryan.coursework.controller;

import com.grigoryan.coursework.entity.Intarface;
import com.grigoryan.coursework.service.IntarfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IntarfaceController {
    private final IntarfaceService intarfaceService;

    @Autowired
    public IntarfaceController(IntarfaceService intarfaceService){
        this.intarfaceService = intarfaceService;
    };

    @PostMapping(value = "/intarface")
    public ResponseEntity<?> create(@RequestBody Intarface intarface) {
        intarfaceService.create(intarface);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/intarface")
    public ResponseEntity<List<Intarface>> read() {
        final List<Intarface> intarface = intarfaceService.readAll();

        return intarface != null & !intarface.isEmpty()
                ? new ResponseEntity<>(intarface, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/intarface/{id}")
    public ResponseEntity<Intarface> read(@PathVariable(name = "id") int id) {
        final Intarface intarface = intarfaceService.read(id);

        return intarface != null
                ? new ResponseEntity<>(intarface, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/intarface/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Intarface intarface) {
        final boolean update = intarfaceService.update(intarface, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/intarface/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = intarfaceService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
