package com.Apple.EmployeeFacade.EmployeeFacade.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/EmpFacade")
@Controller
public class EmployeeFacadeController {

	@RequestMapping("/index")
	public String indexPage(Model model) {
		//System.out.println("Inside index");
		model.addAttribute("message", "Employee UI");	
		return "index";
	}
	
	
}
