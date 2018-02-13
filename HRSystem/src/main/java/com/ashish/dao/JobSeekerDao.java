package com.ashish.dao;

import com.ashish.model.JobSeeker;

public interface JobSeekerDao 
{
	public void saveJobSeeker(JobSeeker js);
	public JobSeeker getId_Password(String Username,String Password);
	public boolean change_password(String username,String Password_new);
	
}
