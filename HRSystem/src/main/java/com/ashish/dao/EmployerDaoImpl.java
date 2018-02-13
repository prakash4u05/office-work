package com.ashish.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashish.model.Employer;

@Repository
@Transactional
public class EmployerDaoImpl implements EmployerDao
{
	@Autowired
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveEmployer(Employer emp) 
	{
		Session session= this.sessionFactory.getCurrentSession();
		session.save(emp);
		
	}

	@Override
	public Employer getId_Password(String Username, String Password) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		Employer emp=new Employer();
		@SuppressWarnings("unchecked")
		List<Object[]> os=session.createQuery("select email as user,password as pass from Employer where email=:username").setParameter("username",Username).list();
		for (Object[] row: os) {
		    emp.setEmail(String.valueOf(row[0]));
		    emp.setPassword(String.valueOf(row[1]));
		    break;
		}
		return emp;
	}

	@Override
	public boolean change_password(String username, String Password_new)
	{
		Session session= this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Employer set password=:password where email=:email");
		query.setString("password",Password_new);
		query.setString("email",username);
		int status=query.executeUpdate();
		return true;
	}
	

}
