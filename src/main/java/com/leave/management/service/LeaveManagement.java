package com.leave.management.service;

import com.leave.management.dto.ActionDTO;
import com.leave.management.dto.EmployeeDTO;
import com.leave.management.dto.LeaveDTO;

public interface LeaveManagement {
	
	public String addEmployee(EmployeeDTO emp);
	public String applyLeave(LeaveDTO leave);
	public String action(ActionDTO action);

}
