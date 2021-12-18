package com.grigoryan.coursework.controller;

import com.grigoryan.coursework.entity.BotFunction;
import com.grigoryan.coursework.service.BotFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BotFunctionController {
    private final BotFunctionService botFunctionService;

    @Autowired
    public BotFunctionController(BotFunctionService botFunctionService){
        this.botFunctionService = botFunctionService;
    };

    @PostMapping(value = "/botFunction")
    public ResponseEntity<?> create(@RequestBody BotFunction botFunction) {
        botFunctionService.create(botFunction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/botFunction")
    public ResponseEntity<List<BotFunction>> read() {
        final List<BotFunction> botFunctions = botFunctionService.readAll();

        return botFunctions != null & !botFunctions.isEmpty()
                ? new ResponseEntity<>(botFunctions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/botFunction/{id}")
    public ResponseEntity<BotFunction> read(@PathVariable(name = "id") int id) {
        final BotFunction botFunctions = botFunctionService.read(id);

        return botFunctions != null
                ? new ResponseEntity<>(botFunctions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/botFunction/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody BotFunction botFunction) {
        final boolean update = botFunctionService.update(botFunction, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/botFunction/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = botFunctionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
