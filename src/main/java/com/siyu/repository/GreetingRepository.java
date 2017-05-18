package com.siyu.repository;

import com.siyu.entity.Greeting;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GreetingRepository extends PagingAndSortingRepository<Greeting, Long> {

  Greeting findByToWhom(String toWhom);
}
