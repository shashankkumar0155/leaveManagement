package com.leave.management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mapId;
	private Integer projectId;
	private Integer employeeId;
	private String employeeName;
	private String employeeEmail;
	public Integer getMapId() {
		return mapId;
	}
	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

}
