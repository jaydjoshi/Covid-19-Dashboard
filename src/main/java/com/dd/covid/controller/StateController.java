package com.dd.covid.controller;

import com.dd.covid.exception.StateNotFoundException;
import com.dd.covid.model.jpa.State;
import com.dd.covid.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/states")
    public List<State> retrieveAllCountries() {
        return (List<State>) stateRepository.findAll();
    }

    @GetMapping("/states/{id}")
    public State getState(@PathVariable long id) throws StateNotFoundException {
        Optional<State> state = stateRepository.findById(id);

        if (!state.isPresent())
            throw new StateNotFoundException("id-" + id);

        return state.get();
    }

    @DeleteMapping("/states/{id}")
    public void deleteState(@PathVariable long id) {
        stateRepository.deleteById(id);
    }

    @PostMapping("/states")
    public ResponseEntity<Object> createStudent(@RequestBody State state) {
        State savedState = stateRepository.save(state);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedState.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/states/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody State state, @PathVariable long id) {

        Optional<State> optionalState = stateRepository.findById(id);

        if (!optionalState.isPresent())
            return ResponseEntity.notFound().build();

        state.setId(id);
        stateRepository.save(state);
        return ResponseEntity.noContent().build();
    }
}
