package com.spring.starter.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.starter.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
