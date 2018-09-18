package com.girnarsoft.springboot;

public class Employee {
	private int id;
	private String name;
	private String phone;
	private String salary;
	private String password;
	private int roleId;
	private int headId;
	
	public Employee() {
		super();
	}
	public Employee(int id, String name, String phone, String salary, String password, int roleId, int headId) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.salary = salary;
		this.password = password;
		this.roleId = roleId;
		this.headId = headId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getHeadId() {
		return headId;
	}
	public void setHeadId(int headId) {
		this.headId = headId;
	}
	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", phone=" + phone + ", salary=" + salary + ", password="
				+ password + ", roleId=" + roleId + ", headId=" + headId + "]\n";
	}
	
	
	

}
