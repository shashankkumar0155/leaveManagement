package com.leave.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leave.management.entity.ProjectMap;

public interface MappingRep extends JpaRepository<ProjectMap, Integer> {

}
