package com.girnarsoft.springboot.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.girnarsoft.springboot.Employee;
import com.girnarsoft.springboot.InvalidInputException;
import com.girnarsoft.springboot.dao.EmployeeDao;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	/**
	 * validates name format
	 * 
	 * @param name
	 * @return
	 */

	public boolean validateName(String name) {
		return name.matches("[a-zA-Z][a-zA-Z ]*");
	}

	/**
	 * validate salary format
	 * 
	 * @param salary
	 * @return
	 */

	public boolean validateSalary(String salary) {
		if (salary.matches("\\d*")) {
			return true;
		} else
			return false;
	}

	/**
	 * check if phone number is in correct format
	 * 
	 * @param phone
	 * @return
	 */

	public boolean validatePhone(String phone) {
		if (phone.matches("\\d*") && phone.length() == 10) {
			return true;
		} else
			return false;
	}

	/**
	 * validates if the Id format is correct
	 * 
	 * @param id
	 * @return
	 */

	public boolean validateId(String id) {
		return id.matches("\\d*");
	}

	/**
	 * finds the List of all Employee Objects
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> viewEmployees() throws SQLException {
		List<Employee> employees = employeeDao.viewAll();
		return employees;
	}

	/**
	 * 
	 * @param name
	 * @param phone
	 * @param salary
	 * @param password
	 * @param roleId
	 * @param headId
	 * @throws InvalidInputException
	 * @throws SQLException
	 * @throws NumberFormatException
	 */
	public void addEmployee(int userId, String name, String phone, String salary, String password, String roleId,
			String headId) throws InvalidInputException, NumberFormatException, SQLException {
		System.out.println("addEmployee");
		int intHeadId = Integer.parseInt(headId);
		if (!employeeDao.checkEmployee(intHeadId))
			throw new InvalidInputException("Manager Id is Incorrect!!");
		if (findRole(userId) < Integer.parseInt(roleId))
			throw new InvalidInputException("Wrong Attempt to add Employee!!!");
		if (findRole(intHeadId) < Integer.parseInt(roleId))
			throw new InvalidInputException("Manager Assignment Invalid !!!");
		employeeDao.saveEmployee(name, phone, salary, password, roleId, headId);

	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int findAdditionId() throws SQLException {
		return employeeDao.findLastId();
	}

	/**
	 * checks if the given id exists removes the employee with the given id
	 * 
	 * @param employeeId
	 * @throws InvalidInputException
	 * @throws SQLException
	 */

	public void removeEmployee(int userId, int employeeId) throws InvalidInputException, SQLException {
		if (!employeeDao.checkEmployee(employeeId))
			throw new InvalidInputException("Employee with this Id is not present in Database");
		else {
			if (employeeDao.getRole(userId) < employeeDao.getRole(employeeId))
				throw new InvalidInputException("You can not remove this employee!!");
			employeeDao.deleteEmployee(employeeId);
		}
	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */
	public Employee findEmployee(int employeeId) throws SQLException {
		return employeeDao.findEmployee(employeeId);
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param phone
	 * @throws SQLException
	 */

	public void editEmployee(int userId, int employeeId, String name, String phone, String salary, String password,
			String headId) throws InvalidInputException, SQLException {
		int intHeadId=Integer.parseInt(headId);
		if (!employeeDao.checkEmployee(intHeadId))
			throw new InvalidInputException("Manager Id is Incorrect!!");
		if (!employeeDao.checkEmployee(employeeId))
			throw new InvalidInputException("Employee with this Id is not present in Database");
		if (employeeDao.getRole(userId) < employeeDao.getRole(employeeId))
			throw new InvalidInputException("You can not edit this employee!!");
		if (findRole(intHeadId) < findRole(employeeId))
			throw new InvalidInputException("Manager Assignment Invalid !!!");
		employeeDao.updateEmployee(employeeId, name, phone, salary, password, headId);

	}

	/**
	 * 
	 * @param userId
	 * @param employeeId
	 * @param roleId
	 * @throws InvalidInputException
	 * @throws SQLException
	 */
	public void promoteEmployee(int userId, int employeeId, int roleId) throws InvalidInputException, SQLException {
		if (!employeeDao.checkEmployee(employeeId))
			throw new InvalidInputException("Employee with this Id is not present in Database");
		else {
			if (employeeDao.getRole(userId) < employeeDao.getRole(employeeId))
				throw new InvalidInputException("You can not promote this employee!!");
			employeeDao.promoteEmployee(employeeId, roleId);
		}

	}

	/**
	 * 
	 * @param intId
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> listAllReporting(int intId) throws InvalidInputException, SQLException {
		List<Employee> employees;
		if (!employeeDao.checkEmployee(intId))
			throw new InvalidInputException("Employee with this Id is not present in Database");
		else {
			employees = employeeDao.listReportingEmployees(intId);
			return employees;
		}
	}

	/**
	 * 
	 * @param id
	 * @param password
	 * @return
	 * @throws InvalidInputException
	 * @throws SQLException
	 */
	public boolean checkPassword(int id, String password) throws InvalidInputException, SQLException {
		if (!employeeDao.checkEmployee(id))
			throw new InvalidInputException("Employee with this Id is not present in Database");
		else
			return employeeDao.verifyPassword(id, password);

	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws InvalidInputException
	 * @throws SQLException
	 */
	public int findRole(int employeeId) throws InvalidInputException, SQLException {
		if (!employeeDao.checkEmployee(employeeId))
			throw new InvalidInputException("Employee with this Id is not present in Database");
		else
			return employeeDao.getRole(employeeId);
	}

}
