package com.leave.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leave.management.entity.LeaveDetails;

public interface LeaveRepo extends JpaRepository<LeaveDetails, Integer> {
	
	public LeaveDetails findByEmployeeId(Integer id);

}
