package com.leave.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leave.management.dto.ActionDTO;
import com.leave.management.dto.EmployeeDTO;
import com.leave.management.dto.LeaveDTO;
import com.leave.management.entity.LeaveDetails;
import com.leave.management.entity.ProjectMap;
import com.leave.management.repository.LeaveRepo;
import com.leave.management.repository.MappingRep;

@Service
public class LeaveManagementImpl implements LeaveManagement {
	
	@Autowired
	MappingRep map;
	
	@Autowired
	LeaveRepo leaveRepo;

	@Override
	public String addEmployee(EmployeeDTO emp) {
		ProjectMap projectMap=new ProjectMap();
		
		LeaveDetails leaveDetails=new LeaveDetails();
		projectMap.setEmployeeEmail(emp.getEmailId());
		projectMap.setEmployeeId(emp.getEmpId());
		projectMap.setEmployeeName(emp.getEmpName());
		projectMap.setMapId(1);
		projectMap.setProjectId(1);
		map.save(projectMap);
		
		leaveDetails.setAcceptRejectRemark("no leave");
		leaveDetails.setDuration(0);
		leaveDetails.setEmployeeId(emp.getEmpId());
		leaveDetails.setManagerId(1);
		leaveDetails.setFromDate(null);
		leaveDetails.setToDate(null);
		leaveDetails.setLeaveType(null);
		leaveDetails.setReason(null);
		leaveRepo.save(leaveDetails);
		return "Employee added and leave tracker update";
	}

	@Override
	public String applyLeave(LeaveDTO leave) {
		LeaveDetails leaveDetails=leaveRepo.findByEmployeeId(leave.getEmployeeId());
		leaveDetails.setAcceptRejectRemark("Awaiting");
		leaveDetails.setDuration(5);
		leaveDetails.setEmployeeId(leave.getEmployeeId());
		leaveDetails.setFromDate(leave.getFromDate());
		leaveDetails.setToDate(leave.getToDate());
		leaveDetails.setLeaveType(leave.getLeaveType());
		leaveDetails.setReason(leave.getReason());
		leaveRepo.save(leaveDetails);
		return "apply leave successFul";
	}

	@Override
	public String action(ActionDTO action) {
		LeaveDetails leaveDetails=leaveRepo.findByEmployeeId(action.getEmployeeId());
		System.out.println(leaveDetails.getAcceptRejectRemark());
		leaveDetails.setAcceptRejectRemark(action.getAction());
		leaveRepo.save(leaveDetails);
		
		return "action is taken as"+action.getAction();
	}

}
