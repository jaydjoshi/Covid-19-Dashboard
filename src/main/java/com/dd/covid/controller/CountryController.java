package com.dd.covid.controller;

import com.dd.covid.exception.StateNotFoundException;
import com.dd.covid.model.jpa.Country;
import com.dd.covid.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> retrieveAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable long id) throws StateNotFoundException {
        Optional<Country> country = countryRepository.findById(id);

        if (!country.isPresent())
            throw new StateNotFoundException("id-" + id);

        return country.get();
    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountry(@PathVariable long id) {
        countryRepository.deleteById(id);
    }

    @PostMapping("/countries")
    public ResponseEntity<Object> createStudent(@RequestBody Country country) {
        Country savedCountry = countryRepository.save(country);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCountry.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/countries/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Country country, @PathVariable long id) {

        Optional<Country> optionalCountry = countryRepository.findById(id);

        if (!optionalCountry.isPresent())
            return ResponseEntity.notFound().build();

        country.setId(id);
        countryRepository.save(country);
        return ResponseEntity.noContent().build();
    }
}
