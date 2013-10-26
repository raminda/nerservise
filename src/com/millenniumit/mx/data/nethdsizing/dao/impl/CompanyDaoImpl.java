/*public class EquipmentMapingDaoImpl {

}*/
package com.millenniumit.mx.data.nethdsizing.dao.impl;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.millenniumit.mx.data.nethdsizing.dao.CompanyDao;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 */
@SuppressWarnings("unchecked")
public class CompanyDaoImpl implements CompanyDao {
	
	
	//*******************************************sessionFactor******************************************
			private String table=new String();
			private SessionFactory SessionFactory;
			private Transaction trans;
			private Session session;
			protected CompanyDaoImpl() {
			}

			/**
			 * @return the SessionFactory
			 */
			public SessionFactory getSessionFactory() {
				return SessionFactory;
			}
			
			/**
			 * @param SessionFactory the SessionFactory to set
			 */
			public void setSessionFactory(SessionFactory SessionFactory) {
				this.SessionFactory = SessionFactory;
			}
			
	//*******************************************end************************************************
	public CompanyDaoImpl(SessionFactory SessionFactory){
		this.SessionFactory=SessionFactory;
		table="from company ";
	}	
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(Long)
	 */
	@Override
	public Company get(int ID) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (Company)session.
				createQuery(table+" where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(String)
	 */
	@Override
	public Company get(String CompanyName) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (Company)session
				.createQuery(table+" where CompanyName =:CompanyName")
				.setParameter("CompanyName", CompanyName).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(String)
	 */
	@Override
	public List<Company> getAll(String CompanyName) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" where CompanyName =:CompanyName")
				.setParameter("CompanyName", CompanyName).list();
	}

	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#getAll()
	 */
	@Override
	public List <Company> getAll() {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" order by CompanyName").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#getAll(int, int)
	 */
	
	@Override
	public List<Company> getAll(int start, int limit) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" order by CompanyName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(Company index){
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.save(index);
		session.flush();trans.commit();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Company index) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
			session.delete(index);
			session.flush();trans.commit();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Company object) {
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
		session.flush();
		trans.commit();
		super.finalize();
	}

}
