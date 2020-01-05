package com.edufyy.backend.question.repository;

import com.edufyy.backend.question.model.HomeWork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorkRepository extends CrudRepository<HomeWork, Long> {

}
