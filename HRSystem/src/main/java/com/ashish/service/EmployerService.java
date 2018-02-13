package com.ashish.service;

import com.ashish.model.Employer;

public interface EmployerService 
{
	public void saveEmployer(Employer emp);
	public boolean getId_Password(String Username,String Password);
	public boolean change_password(String username,String password,String password_new);
}
