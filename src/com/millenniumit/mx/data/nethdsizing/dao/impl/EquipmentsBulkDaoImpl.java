package com.millenniumit.mx.data.nethdsizing.dao.impl;




import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.millenniumit.mx.data.nethdsizing.dao.EquipmentbulkDao;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;

/**
 * 
 * @author Raminda
 *
 */
@SuppressWarnings("unchecked")
public class EquipmentsBulkDaoImpl implements EquipmentbulkDao {
	
	//*******************************************sessionFactor******************************************
	private String table=new String();
	private SessionFactory SessionFactory;
	private Transaction trans;
	private Session session;	
			protected EquipmentsBulkDaoImpl() {
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
	
			public EquipmentsBulkDaoImpl(SessionFactory SessionFactory) {
				table="from equipmentbulk ";
				this.SessionFactory=SessionFactory;
			}		
	//*******************************************end************************************************
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	@Override
	public EquipmentBulk get(int ID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (EquipmentBulk)session
				.createQuery(table + "  where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(EquipmentBulk)
	 */
	@Override
	public List<EquipmentBulk> getAll(Packages PackageID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table + "  where PackageID =:PackageID ")
				.setParameter("PackageID", PackageID).list();
	}
	


	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<EquipmentBulk> getAll() {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table + "  order by PackageID").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<EquipmentBulk> getAll(int start, int limit) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table + "  order by PackageID")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.EquipmentbulkDao.dao.EquipmentsBulkDao#getEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.Equipments )
	 */
	@Override
	public List<EquipmentBulk> getAll(Equipments ItemID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table + "  where ItemID=:ItemID order by PackageID")
				.setParameter("ItemID", ItemID).list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.EquipmentbulkDao.dao.EquipmentsBulkDao#getEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.KpiCategory, java.lang.String)
	 */
	@Override
	public EquipmentBulk get(Packages PackageID, Equipments ItemID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (EquipmentBulk) session
				.createQuery(table + "  where PackageID=:PackageID and ItemID=:ItemID order by PackageID")
				.setParameter("PackageID", PackageID)
				.setParameter("ItemID", ItemID).uniqueResult();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(EquipmentBulk index) {
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
	public void delete(EquipmentBulk index) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		session.delete(index);
		session.flush();trans.commit();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(EquipmentBulk object) {
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
