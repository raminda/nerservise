
package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.dao.EquipmentMapingDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.EquipmentMapingDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentMapingService;

/**
 * 
 * @author Raminda
 *
 */

@Entity
public class  EquipmentMapingServiceImpl implements  EquipmentMapingService {

	
	@ManyToOne
	private EquipmentMapingDao equipmentMapingDao;

	protected EquipmentMapingServiceImpl() {
	}

	/**
	 * @return the EquipmentsBulkDeo
	 */
	public EquipmentMapingDao getEquipmentsMapingDao() {
		return equipmentMapingDao;
	}

	/**
	 * @param EquipmentsBulkDeo the EquipmentsBulkDeo to set
	 */
	public void setEquipmentsMapingDao(EquipmentMapingDao EquipmentsMapingDao) {
		this.equipmentMapingDao = EquipmentsMapingDao;
	}
	public EquipmentMapingServiceImpl (SessionFactory SessionFactory){
		equipmentMapingDao=new EquipmentMapingDaoImpl(SessionFactory);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#getEquipmentsBulk(java.lang.Long)
	 */
	@Override
	public EquipmentMaping getEquipmentMapings(int ID) {
		return getEquipmentsMapingDao().get(ID);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#getEquipmentsBulk(java.lang.String)
	 */
	@Override
	public  List<EquipmentMaping> getEquipmentMapings(Equipments EquipmentID,ItemTypes itemType) {
		return getEquipmentsMapingDao().getAll(EquipmentID,itemType);
	}

	@Override
	public  List<EquipmentMaping> getEquipmentMapings(Equipments PerantID,Equipments ChildID) {
		return getEquipmentsMapingDao().getAll(PerantID,ChildID);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#getEquipmentsBulk()
	 */
	@Override
	public List<EquipmentMaping> getEquipmentMapings() {
		return getEquipmentsMapingDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	public List <EquipmentMaping> getEquipmentMapings(int start, int limit) {
		return getEquipmentsMapingDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#saveEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.EquipmentsBulk)
	 */
	@Override
	public int save(EquipmentMaping index) {
		return getEquipmentsMapingDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#deleteEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.EquipmentsBulk)
	 */
	@Override
	public void delete(EquipmentMaping index) {
		getEquipmentsMapingDao().delete(index);		
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.EquipmentMapingService#update(com.millenniumit.mx.data.itic.domain.EquipmentMaping)
	 */
	@Override
	public void update(EquipmentMaping index) {
		getEquipmentsMapingDao().update(index);
		
	}

}
