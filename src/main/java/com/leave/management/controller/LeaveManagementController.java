package com.leave.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leave.management.dto.ActionDTO;
import com.leave.management.dto.EmployeeDTO;
import com.leave.management.dto.LeaveDTO;
import com.leave.management.service.LeaveManagement;

@RestController
public class LeaveManagementController {
	
	@Autowired
	LeaveManagement leave;
	
	@PostMapping("/resource-add")
	public ResponseEntity<String> addResource(@RequestBody EmployeeDTO employeeDTO)
	{
		String status=leave.addEmployee(employeeDTO);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@PutMapping("/apply-leave")
	public ResponseEntity<String> applyLeave(@RequestBody LeaveDTO leavedto)
	{
		
	String status=leave.applyLeave(leavedto);
	return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@PutMapping("/approve-reject")
	public ResponseEntity<String> acceptReject(@RequestBody ActionDTO action)
	{
		String status=leave.action(action);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}

}
