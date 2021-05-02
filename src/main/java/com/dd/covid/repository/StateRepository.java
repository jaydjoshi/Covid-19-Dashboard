package com.dd.covid.repository;

import com.dd.covid.model.jpa.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {
}
