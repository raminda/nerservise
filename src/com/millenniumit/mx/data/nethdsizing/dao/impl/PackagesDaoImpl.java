package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.millenniumit.mx.data.nethdsizing.dao.PackagesDao;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;

/**
 * 
 * @author DECANS
 *
 */
@SuppressWarnings("unchecked")
public class PackagesDaoImpl implements PackagesDao {


	private String table=new String();
	private SessionFactory SessionFactory;
	private Transaction trans;
	private Session session;
	protected PackagesDaoImpl() {
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
	
	public PackagesDaoImpl(SessionFactory SessionFactory){
		table="from packages ";
		this.SessionFactory=SessionFactory;
	}
	/**
	 *  @param ID
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(String,int)
	 */
	@Override
	public Packages get(int ID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (Packages) session
				.createQuery(table+" where ID =:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	
	@Override
	public List<Packages> getAll(){
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" order by PackageName").list();
	}

	/**
	 * @param id
	 * @param Type =PackagesName-1 PackagesID-2
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(String,int)
	 */
	@Override
	public Packages get(String id) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (Packages) session.createQuery(table+" where PackageName =:PackageName")
					.setParameter("PackageName", id).uniqueResult();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List <Packages> getAll(int start, int limit) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" order by PackageName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	/**
	 * @param date1,date2
	 * @param type= LUDate-1,EOL-2
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(Date,Date,int)
	 */
	@Override
	public List<Packages> getAll(Date date1, Date date2) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" where EOLdate>:date1 and EOLdate<:date2  order by PackageName")
				.setParameter("date1", date1)
				.setParameter("date2", date2).list();
	}
	
	/**
	 * @param data
	 * @param Type
	 * @param =LUdate-1,EOL-2
	 * @param = Equal-1,Greater-2,Lower-3
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(Date,int,int)
	 */
	@Override
	public List<Packages> getAll(Date date,int sumtype) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		if(sumtype==1){
				return session
					.createQuery(table+" where EOLdate=:date order by PackageName")
					.setParameter("date", date).list();
			}
			else if(sumtype==2){
				return session
					.createQuery(table+" where EOLdate>:date order by PackageName")
					.setParameter("date",date).list();
			}
			else{
				return session
					.createQuery(table+" where EOLdate<:date order by PackageName")
					.setParameter("date", date).list();
			}
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(Packages index)  {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.save(index);
		session.flush();trans.commit();
		return index.getId();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Packages index)  {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.delete(index);
		session.flush();trans.commit();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Packages index)  {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.update(index);
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