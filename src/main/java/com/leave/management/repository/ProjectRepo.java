package com.leave.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leave.management.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
