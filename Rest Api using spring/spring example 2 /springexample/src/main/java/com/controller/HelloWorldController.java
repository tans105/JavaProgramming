package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.dao.UserDao;

@Controller
public class HelloWorldController {
	Log log = LogFactory.getLog(HelloWorldController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("msg", "Hello World!");
		return "helloWorld";
	}

	@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
	public String displayMessage(@PathVariable String msg, ModelMap model) {
		model.addAttribute("msg", msg);
		return "helloWorld";
	}

	@RequestMapping(value = "/displayMessage", method = RequestMethod.GET)
	public String displayMessage1(@RequestParam(value = "name") String msg,
			ModelMap model) {

		model.addAttribute("msg", msg);
		return "helloWorld";
	}

	@RequestMapping(value = "/helloemployee", method = RequestMethod.GET)
	public String displayMessage1() {

		return "helloemployee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		log.info("i am working ! ");
		return new ModelAndView("employee", "command", new Employee());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(Employee employee, ModelMap model) {
		System.out.println("status-----------:" + employee.getStatus());
		System.out.println("number-----------:" + employee.getNumber());

		UserDao dao = new UserDao();
		// System.out.println("present is............"+dao.validateEmployeeNumber(employee.getNumber()));
		if (employee.getStatus() > 6)
			return errorPage();
		else {
			dao.updateStatus(employee.getNumber(), employee.getStatus());
			model.addAttribute("status", employee.getStatus());
			model.addAttribute("number", employee.getNumber());

			return "result";
		}
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No such Order")
	public String errorPage() {
		return "badrequest";
	}

}
