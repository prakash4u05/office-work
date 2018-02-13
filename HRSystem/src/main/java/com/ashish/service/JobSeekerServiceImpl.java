package com.ashish.service;

import com.ashish.model.JobSeeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.dao.*;

@Service
public class JobSeekerServiceImpl implements JobSeekerService
{
	@Autowired
	private JobSeekerDao jobSeekerDao;
	
	public void setJobSeekerDao(JobSeekerDao jobSeekerDao) 
	{
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	@Transactional
	public void saveJobSeeker(JobSeeker js)
	{
		
		this.jobSeekerDao.saveJobSeeker(js);
	}

	
	@Override
	@Transactional
	public boolean getId_Password(String Username, String Password) 
	{
		JobSeeker js=this.jobSeekerDao.getId_Password(Username, Password);
		if(js.getPassword().equals(Password))
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
			status=this.jobSeekerDao.change_password(username,password_new);
			if(status)
				return true;
			else
				return false;
		}
		return false;
	}

}
