package com.girnarsoft.springboot;


public class Constants {

	public static interface Queries {
	
		public static final String INSERT_EMPLOYEE = "INSERT INTO `ems`.`employee` ("
				+"  `name`,"
				+"  `doj`,"
				+"	`mobile`,"
				+"  `salary`,"
				+"  `password`,"
				+"  `emp_role_id`,"
				+"  `manager_id`,"
				+"  `created_at`,"
				+"  `updated_at`"
				+") "
				+"VALUES"
				+"  ("
				+"    ?,"
				+"	  CURDATE(),"
				+"    ?,"
				+"    ?,"
				+"    ?,"
				+"    ?,"
				+"    ?,"
				+"    NOW(),"
				+"    NOW()"
				+"  );";
		public static  final String VIEW_EMPLOYEE="select * from employee";
		public static final String SEARCH_EMPLOYEE="select * from employee where id="
				+"?";
		public static final String LIST_REPORTING_EMPLOYEES="select * from employee where manager_id="
				+"	  ?;";
		public static final String UPGRADE_EMPLOYEE="update employee set emp_role_id="
				+"? "
				+"where id ="
				+"?;";
		public static final String UPDATE_EMPLOYEE = "update employee set name= ? ,mobile= ? ,salary=? ,password= ?,manager_id= ? where id= ?";
		public static final String REMOVE_EMPLOYEE="delete from employee where id="
				+"?;";
		public static final String VIEW_MANAGER="select * from employee where id=(select manager_id from employee where id="
				+"	  ?"
				+"	 );";
		public static final String UPDATE_HEAD="update employee set manager_id ="
				+" ?"
				+" where manager_id="
				+" ?;";
	}

}
