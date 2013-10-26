package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.millenniumit.mx.data.nethdsizing.dao.ProjectDao;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.Project;

@SuppressWarnings("unchecked")
public class ProjectDaoImpl implements ProjectDao {
	
	private String table=new String();
	private SessionFactory SessionFactory;
	private Transaction trans;
	private Session session;
	protected ProjectDaoImpl() {
	}

	/**
	 * @return the ITICSessionFactory
	 */
	public SessionFactory getITICSessionFactory() {
		return SessionFactory;
	}

	/**
	 * @param ITICSessionFactory the ITICSessionFactory to set
	 */
	public void setITICSessionFactory(SessionFactory ITICSessionFactory) {
		this.SessionFactory = ITICSessionFactory;
	}
	public ProjectDaoImpl(SessionFactory SessionFactory){
		table="from project ";
		this.SessionFactory=SessionFactory;
	}
	@Override
	public Project get(String id) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (Project) session
				.createQuery(table+" projects where ProjectName=:ProjectName")
				.setParameter("ProjectName", id).uniqueResult();
	}

	@Override
	public List <Project> getCompnay(Company Campanyname) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return  session
				.createQuery(table+" projects where Company=:Campanyname")
				.setParameter("Campanyname", Campanyname).list();
	}

	@Override
	public List<Project> getAll(int start, int limit) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" projects order by ID")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	@Override
	public List<Project> getAll() {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" projects order by  ID ")
				.list();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<String> getAllNames() {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery("select distinct Company from  projects order by Company").list();
	}
	@Override
	public Project get(int ID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (Project) session
				.createQuery(table+" projects where ID =:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	@Override
	public int save(Project index)  {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.save(index);
		session.flush();trans.commit();
		return index.getId();
	}
	

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Project  index)  {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.delete(index);
		session.flush();trans.commit();
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Project object)  {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.update(object);
		session.flush();trans.commit();
	}
	/**
	 * @category Destructor
	 */
	@Override
	protected void finalize() throws Throwable {
		session.flush();trans.commit();
		super.finalize();
	}
}