package com.cs.assignment.repository;

import com.cs.assignment.model.Smoothie;
import org.springframework.data.repository.CrudRepository;

public interface SmoothieDataRepository extends CrudRepository<Smoothie, Long> {}
