package com.girnarsoft.springboot.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.girnarsoft.springboot.Constants;
import com.girnarsoft.springboot.Employee;
import com.girnarsoft.springboot.EmployeeRowMapper;
/**
 * 
 * @author gspl
 *
 */

@Repository
@Component
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */

	public List<Employee> viewAll() throws SQLException {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = jdbcTemplate.query(Constants.Queries.VIEW_EMPLOYEE, new EmployeeRowMapper());
		return employeeList;

	}
	/**
	 * 
	 * @param selfid
	 * @return
	 * @throws SQLException
	 */
	public int getRole(int selfid) throws SQLException{
		return findEmployee(selfid).getRoleId();
	}
	/**
	 * 
	 * @param selfid
	 * @param selfPassword
	 * @return
	 * @throws SQLException
	 */
	public boolean validateUser(int selfid, String selfPassword) throws SQLException{
		List<Employee> employeeObject = new ArrayList<Employee>();
		Object[] args = new Object[] { selfid };
		employeeObject = jdbcTemplate.query(Constants.Queries.SEARCH_EMPLOYEE, args, new EmployeeRowMapper());
		if (employeeObject.get(0).getPassword().equals(selfPassword))
			return true;
		else
			return false;

	}

	/**
	 * checks if the employee with the specific id is present in the database
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkEmployee(int id) throws SQLException{

		List<Employee> employeeObject = new ArrayList<Employee>();
		Object[] args = new Object[] { id };
		employeeObject = jdbcTemplate.query(Constants.Queries.SEARCH_EMPLOYEE, args, new EmployeeRowMapper());
		if (employeeObject.isEmpty())
			return false;
		else
			return true;

	}
	/**
	 * 
	 * @param employeeId
	 * @throws SQLException
	 */

	public void deleteEmployee(int employeeId) throws SQLException{
		Object[] args = new Object[] { employeeId };
		jdbcTemplate.update(Constants.Queries.REMOVE_EMPLOYEE, args);

	}
	/**
	 * 
	 * @param name
	 * @param phone
	 * @param salary
	 * @param password
	 * @param roleId
	 * @param headId
	 * @throws SQLException
	 */

	public void saveEmployee(String name, String phone, String salary, String password, String roleId, String headId) throws SQLException{
		Object[] args = new Object[] { name, phone, salary, password, roleId, headId };
		System.out.println("employeeDao");
		jdbcTemplate.update(Constants.Queries.INSERT_EMPLOYEE, args);
	}
	/**
	 * 
	 * @param employeeId
	 * @param employeeRole
	 * @throws SQLException
	 */

	public void promoteEmployee(int employeeId, int employeeRole) throws SQLException {
		Object[] args = new Object[] { employeeRole + 1, employeeId };
		jdbcTemplate.update(Constants.Queries.UPGRADE_EMPLOYEE, args);

	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param phone
	 * @param salary
	 * @param password
	 * @param headId
	 * @throws SQLException
	 */

	public void updateEmployee(int id, String name, String phone, String salary, String password, String headId) throws SQLException {
		Object[] args = new Object[] { name, phone, salary, password, Integer.parseInt(headId), id };
		System.out.println("hiidao");
		jdbcTemplate.update(Constants.Queries.UPDATE_EMPLOYEE, args);

	}
	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */

	public Employee getHead(int employeeId) throws SQLException{
		List<Employee> employeeList = new ArrayList<Employee>();

		Object[] args = new Object[] { employeeId };
		employeeList = jdbcTemplate.query(Constants.Queries.VIEW_MANAGER, args, new EmployeeRowMapper());
		return employeeList.get(0);
	}
	/**
	 * 
	 * @param oldHead
	 * @param newHead
	 * @throws SQLException
	 */

	public void updateHead(int oldHead, int newHead) throws SQLException{

		Object[] args = new Object[] { newHead, oldHead };
		jdbcTemplate.update(Constants.Queries.UPDATE_HEAD, args);

	}
	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */

	public List<Employee> listReportingEmployees(int employeeId) throws SQLException{
		List<Employee> employeeList = new ArrayList<Employee>();

		Object[] args = new Object[] { employeeId };
		employeeList = jdbcTemplate.query(Constants.Queries.LIST_REPORTING_EMPLOYEES, args, new EmployeeRowMapper());
		return employeeList;

	}
	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */

	public Employee findEmployee(int employeeId) throws SQLException{
		List<Employee> employeeList = new ArrayList<Employee>();

		Object[] args = new Object[] { employeeId };
		employeeList = jdbcTemplate.query(Constants.Queries.SEARCH_EMPLOYEE, args, new EmployeeRowMapper());
		return employeeList.get(0);

	}
	/**
	 * 
	 * @param empId
	 * @param password
	 * @return
	 * @throws SQLException
	 */

	public boolean verifyPassword(int empId, String password) throws SQLException{
		String sql = "select name,id,password from employee where id = " + empId + "&& password = '" + password + "'";
		System.out.println(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println(list);
		if (list.isEmpty())
			return false;
		else
			return true;

	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */

	public int findLastId() throws SQLException {
		List<Employee> employeeObject = new ArrayList<Employee>();

		employeeObject = jdbcTemplate.query(Constants.Queries.VIEW_EMPLOYEE, new EmployeeRowMapper());

		int size = employeeObject.size();
		return employeeObject.get(size - 1).getId();

	}
	/**
	 * 
	 * @param empId
	 * @return
	 * @throws SQLException
	 */

	public String getDesignation(int empId)throws SQLException {
		String sql = "select role_name from role inner join employee on employee.emp_role_id = role.role_id where id = "
				+ empId;
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list.get(0).get("role_name").toString();
	}

}
