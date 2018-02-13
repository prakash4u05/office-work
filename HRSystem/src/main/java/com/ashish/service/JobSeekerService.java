package com.ashish.service;

import com.ashish.model.JobSeeker;

public interface JobSeekerService 
{
	public void saveJobSeeker(JobSeeker js);
	public boolean getId_Password(String Username,String Password);
	public boolean change_password(String username,String password,String password_new);
}
