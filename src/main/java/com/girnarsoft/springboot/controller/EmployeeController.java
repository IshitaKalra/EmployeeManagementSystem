package com.girnarsoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.girnarsoft.springboot.Employee;
import com.girnarsoft.springboot.InvalidInputException;
import com.girnarsoft.springboot.services.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */

	@RequestMapping("/exit")
	public String menu(@RequestParam("userId") String userId, Model model) {
		model.addAttribute("userId", userId);
		try {
			int employeeId = Integer.parseInt(userId);
			System.out.println(employeeService.findRole(employeeId));
			if (employeeService.findRole(employeeId) == 1)
				return "employee";
			if (employeeService.findRole(employeeId) == 2)
				return "manager";
			if (employeeService.findRole(employeeId) == 3)
				return "ceo";
			if (employeeService.findRole(employeeId) == 4)
				return "ceo";

		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";
	}

	/**
	 * 
	 * @param userId
	 * @param password
	 * @param model
	 * @return
	 */

	@RequestMapping("/hello")
	public String sayHello(@RequestParam("userId") String userId, @RequestParam("password") String password,
			Model model) {
		model.addAttribute("userId", userId);
		model.addAttribute("pass", password);
		try {
			if (employeeService.checkPassword(Integer.parseInt(userId), password)) {
				int employeeId = Integer.parseInt(userId);
				System.out.println(employeeService.findRole(employeeId));
				if (employeeService.findRole(employeeId) == 1)
					return "employee";
				if (employeeService.findRole(employeeId) == 2)
					return "manager";
				if (employeeService.findRole(employeeId) == 3)
					return "ceo";
				if (employeeService.findRole(employeeId) == 4)
					return "ceo";
			} else {
				model.addAttribute("display", "enter correct details!!!");
				return "index";
			}
		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "index";
	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */

	@RequestMapping("/view")
	public String viewEmployees(@RequestParam("userId") String userId, Model model) {
		List<Employee> employees;
		try {
			model.addAttribute("userId", userId);
			employees = employeeService.viewEmployees();
			model.addAttribute("display", employees);
			return "display";
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";
	}

	/**
	 * 
	 * @param userId
	 * @param name
	 * @param phone
	 * @param password
	 * @param roleId
	 * @param headId
	 * @param salary
	 * @param model
	 * @return
	 */

	@RequestMapping("/add")
	public String addEmployees(@RequestParam("userId") String userId, @RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("password") String password,
			@RequestParam("roleId") String roleId, @RequestParam("headId") String headId,
			@RequestParam("salary") String salary, Model model) {
		try {
			System.out.println(headId);
			model.addAttribute("userId", userId);
			int intId = Integer.parseInt(userId);
			employeeService.addEmployee(intId, name, phone, salary, password, roleId, headId);
			model.addAttribute("display", "Employee " + name + " has been Added successfully with Id "
					+ employeeService.findAdditionId() + "!!!");
			return "display";
		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";
	}

	/**
	 * 
	 * @param userId
	 * @param employeeId
	 * @param name
	 * @param phone
	 * @param password
	 * @param headId
	 * @param salary
	 * @param model
	 * @return
	 */
	@RequestMapping("/editEmployee")
	public String editEmployees(@RequestParam("userId") String userId, @RequestParam("employeeId") String employeeId,
			@RequestParam("name") String name, @RequestParam("phone") String phone,
			@RequestParam("password") String password, @RequestParam("headId") String headId,
			@RequestParam("salary") String salary, Model model) {
		model.addAttribute("userId", userId);
		try {
			int intId = Integer.parseInt(userId);
			employeeService.editEmployee(intId, Integer.parseInt(employeeId), name, phone, salary, password, headId);
			model.addAttribute("display", "Employee Details has been edited successfully!!");

			return "display";
		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";
	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployeePage(@RequestParam("userId") String userId, Model model) {
		ModelAndView modelView = new ModelAndView("add");
		model.addAttribute("userId", userId);
		return modelView;
	}

	/**
	 * 
	 * @param userId
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@RequestMapping("/editEmployeePage")
	public ModelAndView editEmployeePage(@RequestParam("userId") String userId,
			@RequestParam("editId") String employeeId, Model model) {
		ModelAndView modelView = new ModelAndView("edit");
		try {
			model.addAttribute("userId", userId);
			model.addAttribute("employeeId", employeeId);
			model.addAttribute("name", employeeService.findEmployee(Integer.parseInt(employeeId)).getName());
			model.addAttribute("employee", employeeService.findEmployee(Integer.parseInt(employeeId)));
			return modelView;
		} catch (Exception e) {
			System.out.println("WRONG INPUT!!!!");
		}
		return modelView;
	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/getEditId")
	public ModelAndView getEditIdPage(@RequestParam("userId") String userId, Model model) {
		ModelAndView modelView = new ModelAndView("getEditId");
		model.addAttribute("userId", userId);
		return modelView;
	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/indexPage")
	public ModelAndView indexPage(@RequestParam("userId") String userId, Model model) {
		ModelAndView modelView = new ModelAndView("index");
		model.addAttribute("userId", userId);
		return modelView;
	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */

	@RequestMapping("/removeEmployee")
	public ModelAndView removeEmployeePage(@RequestParam("userId") String userId, Model model) {
		ModelAndView modelView = new ModelAndView("remove");
		model.addAttribute("userId", userId);
		return modelView;
	}

	/**
	 * 
	 * @param userId
	 * @param deleteId
	 * @param model
	 * @return
	 */

	@RequestMapping("/remove")
	public String deleteEmployee(@RequestParam("userId") String userId, @RequestParam("deleteId") String deleteId,
			Model model) {
		try {
			// validate id
			int intId = Integer.parseInt(userId);
			int deleteIntId = Integer.parseInt(deleteId);
			employeeService.removeEmployee(intId, deleteIntId);
			model.addAttribute("display", "Employee was successfully deleted from database!!");
			model.addAttribute("userId", userId);
			return "display";
		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
			model.addAttribute("userId", userId);
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";

	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */

	@RequestMapping("/promotePage")
	public ModelAndView promoteEmployeePage(@RequestParam("userId") String userId, Model model) {
		ModelAndView modelView = new ModelAndView("promote");
		model.addAttribute("userId", userId);
		return modelView;
	}

	/**
	 * 
	 * @param userId
	 * @param promoteId
	 * @param model
	 * @return
	 */
	@RequestMapping("/promoteEmployee")
	public String promoteEmployee(@RequestParam("userId") String userId, @RequestParam("promoteId") String promoteId,
			Model model) {
		model.addAttribute("userId", userId);
		try {
			int intId = Integer.parseInt(userId);
			int promoteIntId = Integer.parseInt(promoteId);
			int RoleId = employeeService.findRole(promoteIntId);
			employeeService.promoteEmployee(intId, promoteIntId, RoleId);
			model.addAttribute("display", "Employee was successfully Promoted!!");

			return "display";
		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";

	}

	/**
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/listAll")
	public String listReportingEmployees(@RequestParam("userId") String userId, Model model) {
		try {
			// validate id
			int intId = Integer.parseInt(userId);
			List<Employee> list = employeeService.listAllReporting(intId);
			model.addAttribute("display", list);
			model.addAttribute("userId", userId);
			return "display";
		} catch (InvalidInputException e) {
			model.addAttribute("display", e.getMessage());
			model.addAttribute("userId", userId);
		} catch (Exception e) {
			model.addAttribute("display", "WRONG INPUT!!!!");
		}
		return "display";

	}

}
