package com.girnarsoft.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author gspl
 *
 */

public class EmployeeRowMapper implements RowMapper<Employee> {
	
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setPassword(rs.getString("password"));
		employee.setPhone(rs.getString("mobile"));
		employee.setSalary(rs.getString("salary"));
		employee.setRoleId(rs.getInt("emp_role_id"));
		employee.setHeadId(rs.getInt("manager_id"));
		return employee;
	}

}
