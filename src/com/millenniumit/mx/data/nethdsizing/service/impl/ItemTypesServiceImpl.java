package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;
import com.millenniumit.mx.data.nethdsizing.dao.ItemTypesDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.ItemTypesDaoImpl;

/**
 * 
 * @author Raminda
 *
 */


public class  ItemTypesServiceImpl implements  ItemTypesService {

	
	private ItemTypesDao ItemTypesDao;
	
	protected ItemTypesServiceImpl() {
	}
	public ItemTypesServiceImpl(SessionFactory Sessioactory){
		ItemTypesDao=new ItemTypesDaoImpl(Sessioactory);
	}
	/**
	 * @return the ItemTypesDeo
	 */
	public ItemTypesDao getItemTypesDao() {
		return ItemTypesDao;
	}

	/**
	 * @param ItemTypesDeo the ItemTypesDeo to set
	 */
	public void setItemTypesDao(ItemTypesDao ItemTypesDao) {
		this.ItemTypesDao = ItemTypesDao;
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ItemTypesService#getItemTypes(java.lang.Long)
	 */
	@Override
	public ItemTypes getItemTypess(int id) {
		return getItemTypesDao().get(id);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ItemTypesService#getItemTypes(java.lang.String)
	 */
	@Override
	public ItemTypes get(String ItemTypesName) {
		return getItemTypesDao().get(ItemTypesName);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ItemTypesService#getItemTypes()
	 */
	@Override
	public List<ItemTypes> getItemTypes() {
		return getItemTypesDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	public List <ItemTypes> getItemTypes(int start, int limit) {
		return getItemTypesDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ItemTypesService#saveItemTypes(com.millenniumit.mx.data.ITIC.domain.ItemTypes)
	 */
	@Override
	public int save(ItemTypes index){
		return getItemTypesDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ItemTypesService#deleteItemTypes(com.millenniumit.mx.data.ITIC.domain.ItemTypes)
	 */
	@Override
	public void delete(ItemTypes index) {
		getItemTypesDao().delete(index);		
	}

	/** (non-Javadoc)
	 * @throws Exception 
	 * @see com.millenniumit.mx.data.itic.service.ItemTypesService#update(com.millenniumit.mx.data.itic.domain.ItemTypes)
	 */
	@Override
	public void update(ItemTypes index) {
		getItemTypesDao().update(index);
	}

}
