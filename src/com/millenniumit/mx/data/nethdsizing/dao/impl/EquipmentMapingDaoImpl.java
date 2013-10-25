/*public class EquipmentMapingDaoImpl {

}*/
package com.millenniumit.mx.data.nethdsizing.dao.impl;




import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.millenniumit.mx.data.nethdsizing.dao.EquipmentMapingDao;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;

/**
 * 
 * @author Raminda
 *
 */
@Entity
@SuppressWarnings("unchecked")
public class EquipmentMapingDaoImpl implements EquipmentMapingDao {
	
	//*******************************************sessionFactor******************************************
	
			private String table=new String();
			private SessionFactory SessionFactory;
			private Transaction trans;
			private Session session;
			protected EquipmentMapingDaoImpl() {
			}

			/**
			 * @return  SessionFactory
			 */
			public SessionFactory getITICSessionFactory() {
				return SessionFactory;
			}
			
			/**
			 * @param SessionFactory
			 */
			public void setITICSessionFactory(SessionFactory ITICSessionFactory) {
				this.SessionFactory = ITICSessionFactory;
			}
			public EquipmentMapingDaoImpl(SessionFactory SessionFactory){
				table="from Equipmentmaping ";
				
				this.SessionFactory=SessionFactory;
			}
	//*******************************************end************************************************
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	@Override
	public EquipmentMaping get(int ID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (EquipmentMaping)session
				.createQuery(table+" where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(EquipmentBulk)
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ParentID,Equipments ChildID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" where ParentID =:ParentID and ChildID=:ChildID")
				.setParameter("ParentID", ParentID)
				.setParameter("ChildID", ChildID).list();
	}
	


	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<EquipmentMaping> getAll() {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery("from equipmentmaping order by ParentID").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<EquipmentMaping> getAll(int start, int limit) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery("from equipmentmaping order by ParentID")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.EquipmentMapingDaoImpl#getEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.Equipments )
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ItemID,ItemTypes itemType) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery("from equipmentmaping where ChildID=ChildID.ID and ChildID.ItemType=:itemType and ParentID=:ParentID ")
				.setParameter("ParentID", ItemID)
				.setParameter("itemType", itemType).list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(EquipmentMaping index) {
		session=SessionFactory.getCurrentSession();
		 trans=session.beginTransaction();
		session.save(index);
		session.flush();trans.commit();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(EquipmentMaping index) {
		
		session=SessionFactory.getCurrentSession();
		 trans=session.beginTransaction();
		session.delete(index);
		session.flush();trans.commit();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(EquipmentMaping object) {
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
