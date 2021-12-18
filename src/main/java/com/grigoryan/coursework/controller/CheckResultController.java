package com.grigoryan.coursework.controller;

import com.grigoryan.coursework.entity.CheckResult;
import com.grigoryan.coursework.service.CheckResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckResultController{

    private final CheckResultService checkResultService;

    @Autowired
    public CheckResultController(CheckResultService checkResultService){
        this.checkResultService = checkResultService;
    };

    @PostMapping(value = "/checkResult")
    public ResponseEntity<?> create(@RequestBody CheckResult checkResult) {
        checkResultService.create(checkResult);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/checkResult")
    public ResponseEntity<List<CheckResult>> read() {
        final List<CheckResult> checkResult = checkResultService.readAll();

        return checkResult != null & !checkResult.isEmpty()
                ? new ResponseEntity<>(checkResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/checkResult/{id}")
    public ResponseEntity<CheckResult> read(@PathVariable(name = "id") int id) {
        final CheckResult checkResult = checkResultService.read(id);

        return checkResult != null
                ? new ResponseEntity<>(checkResult, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/checkResult/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody CheckResult checkResult) {
        final boolean update = checkResultService.update(checkResult, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/checkResult/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = checkResultService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
