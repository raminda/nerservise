package com.millenniumit.mx.data.nethdsizing.dao.impl;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.millenniumit.mx.data.nethdsizing.dao.ItemTypesDao;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author Raminda
 *
 */
@SuppressWarnings("unchecked")
public class ItemTypesDaoImpl implements ItemTypesDao {
	
	//*******************************************sessionFactor******************************************
	
	private String table=new String();
	private SessionFactory SessionFactory;
	private Transaction trans;
	private Session session;
			protected ItemTypesDaoImpl() {
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
			public ItemTypesDaoImpl(SessionFactory SessionFactory){
				table="from ItemTypes ";
				this.SessionFactory=SessionFactory;
			}
		//*******************************************end************************************************


	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	@Override
	public ItemTypes get(int  ID) {
		session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (ItemTypes) session
				.createQuery(table+"  where ID =:ID and TypeName!='base'")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(String)
	 */
	@Override
	public ItemTypes get(String TypeName) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return (ItemTypes) session
				.createQuery(table+"  where TypeName!='base'and TypeName=:TypeName")
				.setParameter("TypeName", TypeName).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(int)
	 */
	@Override
	public  List<ItemTypes> getAll(int  AccsessLevel) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" where TypeName!='base' and AccsessLevel =:AccsessLevel order by TypeName")
				.setParameter("AccsessLevel",  AccsessLevel).list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<ItemTypes> getAll() {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" where TypeName!='base' order by TypeName").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<ItemTypes> getAll(int start, int limit) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
		return session
				.createQuery(table+" where TypeName!='base' order by TypeName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public int save(ItemTypes index){
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
	public void delete(ItemTypes index) {
		 session=SessionFactory.getCurrentSession();
		trans=session.beginTransaction();
			session.flush();trans.commit();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(ItemTypes object)  {
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
