package com.millenniumit.mx.data.nethdsizing.service.impl;

/*public class EquipmentsBulkServiceImpl {

}
*/

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsBulkService;
import com.millenniumit.mx.data.nethdsizing.dao.EquipmentbulkDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.EquipmentsBulkDaoImpl;

/**
 * 
 * @author Raminda
 *
 */

@Entity
public class  EquipmentBulkServiceImpl implements  EquipmentsBulkService {

	@ManyToOne
	private EquipmentbulkDao EquipmentsBulkDao;

	protected EquipmentBulkServiceImpl() {
	}
	/**
	 * @return the EquipmentsBulkDeo
	 */
	public EquipmentbulkDao getEquipmentsBulkDao() {
		return EquipmentsBulkDao;
	}
	public EquipmentBulkServiceImpl (SessionFactory SessionFactory){
		EquipmentsBulkDao=new EquipmentsBulkDaoImpl(SessionFactory);
	}
	/**
	 * @param EquipmentsBulkDeo the EquipmentsBulkDeo to set
	 */
	public void setEquipmentsBulkDao(EquipmentbulkDao EquipmentsBulkDao) {
		this.EquipmentsBulkDao = EquipmentsBulkDao;
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#getEquipmentsBulk(java.lang.Long)
	 */
	@Override
	public EquipmentBulk getEquipmentsBulks(int id) {
		return getEquipmentsBulkDao().get(id);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#getEquipmentsBulk(java.lang.String)
	 */
	@Override
	public  List<EquipmentBulk> getEquipmentsBulk(Equipments EquipmentID) {
		return getEquipmentsBulkDao().getAll(EquipmentID);
	}

	@Override
	public  List<EquipmentBulk> getPackageBulk(Packages PackageID) {
		return getEquipmentsBulkDao().getAll(PackageID);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#getEquipmentsBulk()
	 */
	@Override
	public List<EquipmentBulk> getEquipmentsBulk() {
		return getEquipmentsBulkDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	public List <EquipmentBulk> getEquipmentsBulk(int start, int limit) {
		return getEquipmentsBulkDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#saveEquipmentsBulk(com.millenniumit.mx.data.EquipmentBulk.domain.EquipmentsBulk)
	 */
	@Override
	public int save(EquipmentBulk index) {
		return getEquipmentsBulkDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#deleteEquipmentsBulk(com.millenniumit.mx.data.EquipmentBulk.domain.EquipmentsBulk)
	 */
	@Override
	public void delete(EquipmentBulk index) {
		getEquipmentsBulkDao().delete(index);		
	}

	@Override
	public EquipmentBulk EquipmentsBulkget(Packages PackageID,Equipments ItemId) {
		return getEquipmentsBulkDao().get(PackageID, ItemId);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.EquipmentsBulkService#update(com.millenniumit.mx.data.itic.domain.EquipmentsBulk)
	 */
	@Override
	public void update(EquipmentBulk index) {
		getEquipmentsBulkDao().update(index);
		
	}

}
