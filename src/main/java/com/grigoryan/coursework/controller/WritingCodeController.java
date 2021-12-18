package com.grigoryan.coursework.controller;

import com.grigoryan.coursework.entity.WritingCode;
import com.grigoryan.coursework.service.WritingCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WritingCodeController {
    private final WritingCodeService writingCodeService;

    @Autowired
    public WritingCodeController(WritingCodeService writingCodeService){
        this.writingCodeService = writingCodeService;
    };

    @PostMapping(value = "/writingCode")
    public ResponseEntity<?> create(@RequestBody WritingCode writingCode) {
        writingCodeService.create(writingCode);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/writingCode")
    public ResponseEntity<List<WritingCode>> read() {
        final List<WritingCode> writingCode = writingCodeService.readAll();

        return writingCode != null & !writingCode.isEmpty()
                ? new ResponseEntity<>(writingCode, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/writingCode/{id}")
    public ResponseEntity<WritingCode> read(@PathVariable(name = "id") int id) {
        final WritingCode writingCode = writingCodeService.read(id);

        return writingCode != null
                ? new ResponseEntity<>(writingCode, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/writingCode/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody WritingCode writingCode) {
        final boolean update = writingCodeService.update(writingCode, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/writingCode/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = writingCodeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
