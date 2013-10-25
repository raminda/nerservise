package com.millenniumit.mx.data.nethdsizing.service.impl;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.SessionFactory;


import com.millenniumit.mx.data.nethdsizing.dao.EquipmentsDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.EquipmentsDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsService;

	/**
	 * 
	 * @author Raminda
	 *
	 */

@Entity
public class  EquipmentsServiceImpl implements  EquipmentsService {
		
		@ManyToOne
		private EquipmentsDao equipmentsDao;

		protected EquipmentsServiceImpl() {
		}

		/**
		 * @return the SiteTypeDeo
		 */
		public EquipmentsDao getEquipmentsDao() {
			return equipmentsDao;
		}

		/**
		 * @param SiteTypeDeo the SiteTypeDeo to set
		 */
		public void setEquipmentsDao(EquipmentsDao equipmentsDao) {
			this.equipmentsDao = equipmentsDao;
		}

		public EquipmentsServiceImpl(SessionFactory SessionFactory){
			equipmentsDao=new EquipmentsDaoImpl(SessionFactory);
		}
		
		/** (non-Javadoc)
		 * @see com.millenniumit.mx.data.ITIC.service.SiteTypeService#getSiteType(java.lang.Long)
		 */
		@Override
		public Equipments getEquipments(int id) {
			return getEquipmentsDao().get(id);
		}
		
		/** (non-Javadoc)
		 * @see com.millenniumit.mx.data.ITIC.service.SiteTypeService#getSiteType(java.lang.Long)
		 */
		@Override
		public List<Equipments> getBase(int id) {
			return getEquipmentsDao().getBases(id);
		}
		@Override
		public Equipments getEquipments(String Equipments) {
			return getEquipmentsDao().getName(Equipments);
		}

		@Override
		public List<Equipments> getEquipments(int start, int limit) {
			return getEquipmentsDao().getAll(start, limit);
		}

		@Override
		public List<Equipments> getAll(ItemTypes equipmentsType) {
			return getEquipmentsDao().getAll(equipmentsType);
		}

		@Override
		public List<Equipments> getAll(Long Price, int sumtype) {
			return getEquipmentsDao().getAll(Price, sumtype);
		}

		@Override
		public List<Equipments> getAll(Date date, int sumtype) {
			return getEquipmentsDao().getAll(date,sumtype);
		}

		@Override
		public List<Equipments> getAll(Date date1, Date date2) {
			return getEquipmentsDao().getAll(date1, date2);
		}

		@Override
		public List<Equipments> getAll() {
			return getEquipmentsDao().getAll();
		}
		
		/** (non-Javadoc)
		 * @throws Exception 
		 * @see com.millenniumit.mx.data.ITIC.service.SiteTypeService#saveSiteType(com.millenniumit.mx.data.ITIC.domain.SiteType)
		 */
		@Override
		public int save(Equipments index)  {
			return getEquipmentsDao().save(index);
		}

		/** (non-Javadoc)
		 * @throws Exception 
		 * @see com.millenniumit.mx.data.ITIC.service.SiteTypeService#deleteSiteType(com.millenniumit.mx.data.ITIC.domain.SiteType)
		 */
		@Override
		public void delete(Equipments index)  {
			getEquipmentsDao().delete(index);		
		}
		
		/** (non-Javadoc)
		 * @throws Exception 
		 * @see com.millenniumit.mx.data.itic.service.EquipmentsService#update(com.millenniumit.mx.data.itic.domain.Equipments)
		 */
		@Override
		public void update(Equipments index)  {
			getEquipmentsDao().update(index);
			
		}
		
}
