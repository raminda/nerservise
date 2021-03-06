package com.millenniumit.mx.data.nethdsizing.dao;



import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;

/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 */
public interface   EquipmentbulkDao extends Dao <EquipmentBulk> {

	/* abstract Methods For  implementation in Imp. class   */
			
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public EquipmentBulk get(int ID);
	
	/**
	 * 
	 * @param packages
	 * @return
	 */
	public  List<EquipmentBulk> getAll(Packages packages);
	
	/**
	 * 
	 * @param equipments
	 * @return
	 */
	public  List<EquipmentBulk> getAll(Equipments equipments);
	
	/**
	 * 
	 * @param packages
	 * @param equipments
	 * @return
	 */
	public  EquipmentBulk get(Packages packages, Equipments equipments);
	
	/**
	 * 
	 * @param Start,Limit
	 * @return
	 */
	public  List<EquipmentBulk> getAll(int start, int limit);
	
	/**
	 * 
	 * @return
	 */
	public  List<EquipmentBulk> getAll();
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public int save(EquipmentBulk object);
	
	/**
	 * 
	 * @param object
	 */
	public  void delete(EquipmentBulk object);
	
	/**
	 * 
	 * @param object
	 */
	public void update(EquipmentBulk object);
	
}

