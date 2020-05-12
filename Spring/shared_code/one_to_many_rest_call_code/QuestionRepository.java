package com.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{

}
