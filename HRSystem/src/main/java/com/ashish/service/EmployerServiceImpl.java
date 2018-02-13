package com.ashish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.dao.EmployerDao;
import com.ashish.model.Employer;

@Service
public class EmployerServiceImpl implements EmployerService
{
	@Autowired
	private EmployerDao employerDao;
    
	public void setEmployerDao(EmployerDao employerDao) 
	{
		this.employerDao = employerDao;
	}

	@Override
	@Transactional
	public void saveEmployer(Employer emp) 
	{
		
		this.employerDao.saveEmployer(emp);
	}

	@Override
	public boolean getId_Password(String Username, String Password)
	{
		Employer emp=this.employerDao.getId_Password(Username, Password);
		if(emp.getPassword().equals(Password))
			return true;
		else
		return false;
	}

	@Override
	@Transactional
	public boolean change_password(String username, String password, String password_new) 
	{
		boolean status=this.getId_Password(username, password);
		if(status)
		{
			status=this.employerDao.change_password(username,password_new);
			if(status)
				return true;
			else
				return false;
		}
		return false;
	}

}
