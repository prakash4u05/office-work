package com.ashish.dao;

import com.ashish.model.Employer;

public interface EmployerDao 
{
	public void saveEmployer(Employer emp);
	public Employer getId_Password(String Username,String Password);
	public boolean change_password(String username,String Password_new);
}
