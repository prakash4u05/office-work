package com.ashish.dao;

import com.ashish.model.JobSeeker;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JobSeekerDaoImpl implements JobSeekerDao
{
	@Autowired
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    @Override
	public void saveJobSeeker(JobSeeker js)
	{
		Session session= this.sessionFactory.getCurrentSession();
		session.save(js);
		
	}
    @Override
	public JobSeeker getId_Password(String Username,String Password)
	{
		Session session=this.sessionFactory.getCurrentSession();
		JobSeeker js=new JobSeeker();
		@SuppressWarnings("unchecked")
		List<Object[]> os=session.createQuery("select username as user,password as pass,name as name from JobSeeker where username=:username").setParameter("username",Username).list();
		for (Object[] row: os) {
		    js.setUsername(String.valueOf(row[0]));
		    js.setPassword(String.valueOf(row[1]));
		    js.setName(String.valueOf(row[2]));
		    break;
		}
		return js;
	}

	@Override
	public boolean change_password(String username, String Password_new)
	{
		Session session= this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("update JobSeeker set password=:password where username=:username");
		query.setString("password",Password_new);
		query.setString("username",username);
		int status=query.executeUpdate();
		return true;
	}
	
}

