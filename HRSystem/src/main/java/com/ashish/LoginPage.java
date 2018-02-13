package com.ashish;
import com.ashish.service.*;
//import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPage 
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
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session,HttpServletRequest req,HttpServletResponse res)
	{
		boolean status;
		
		String user=req.getParameter("user");
		String password=req.getParameter("pass");
		String type=req.getParameter("type");
		if(type.equals("jobseeker"))
		{
			status=this.jobSeekerService.getId_Password(user, password);
			if(status)
			{
				session.setAttribute("name", user);
				session.setAttribute("type","jobseeker");
				return new ModelAndView("welcomepage");
			}
			else
				return new ModelAndView("welcomepage","msg","invalid login-id and password");
		}
		else
		{
			status=this.employerService.getId_Password(user,password);
			if(status)
			{
				session.setAttribute("name", user);
				session.setAttribute("type","employer");
				return new ModelAndView("welcomepage");
			}
			else
				return new ModelAndView("welcomepage","msg","invalid login-id and password");
		}
		
	}
	
	@RequestMapping("/change_password")
	public ModelAndView change_password()
	{
		return new ModelAndView("passwordchange");
	}
	@RequestMapping("/change_password/change")
	public ModelAndView change_pass(HttpSession session,HttpServletRequest req,HttpServletResponse res)
	{
		boolean status;
		String password_new=req.getParameter("password_new");
		String password=req.getParameter("password");
		String user=(String)session.getAttribute("name");
		String type=(String)session.getAttribute("type");
		if(type.equals("jobseeker"))
			status=this.jobSeekerService.change_password(user, password, password_new);
		else
			status=this.employerService.change_password(user, password, password_new);
		if(status)
			return new ModelAndView("success");
		else
			return new ModelAndView("passwordchange","msg","either username or password is incorrect");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session)
	{
		session.invalidate();
		return new ModelAndView("index");
	}
}
