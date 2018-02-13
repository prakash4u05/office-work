package com.ashish;

import com.ashish.service.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.ashish.model.*;
@Controller
public class RegisterController 
{
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	
	@Autowired(required=true)
	@Qualifier(value="employerService")
	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}
	@Autowired(required=true)
	@Qualifier(value="jobSeekerService")
	public void setJobSeekerService(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }
	@RequestMapping("/register")
	public ModelAndView register()
	{
		return new ModelAndView("register");
	}
	@RequestMapping("/employerregister")
	public ModelAndView employerregister()
	{
		return new ModelAndView("employerregister");
	}
	@RequestMapping(value="/employerregister/register",method = RequestMethod.POST)
	public ModelAndView employerregister_control(HttpSession session,@ModelAttribute("employer") Employer emp) throws ParseException
	{
		String msg=emp.getDesignation();
		Date date=new Date();
		DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		String s=dateformat.format(date);
		 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(s);
		 emp.setReg_date(date1);
		 session.setAttribute("name",emp.getCompany_name());
		 this.employerService.saveEmployer(emp);
		return new ModelAndView("welcomepage","msg",msg);
	}
	@RequestMapping("/jobseekerregister" )
	public ModelAndView jobseekerregister()
	{
		return new ModelAndView("jobseekerregister");
	}
	@RequestMapping(value="/jobseekerregister/register",method = RequestMethod.POST)
	public ModelAndView jobseekerregister_control(@ModelAttribute("jbseeker") JobSeeker js) throws ParseException
	{
		Date date=new Date();
		DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		String s=dateformat.format(date);
		 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(s);
		 js.setReg_date(date1);
		String msg=String.valueOf(js.getReg_date());
		this.jobSeekerService.saveJobSeeker(js);
		return new ModelAndView("welcomepage","msg",msg);
	}
}
