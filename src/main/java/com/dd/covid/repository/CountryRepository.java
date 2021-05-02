package com.dd.covid.repository;

import com.dd.covid.model.jpa.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
