package com.millenniumit.mx.data.nethdsizing.dao;



import java.util.List;


import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
/**
 * 
 * @author DECANS
 *
 */
public interface  ProjectDao extends Dao <Project> {

							/* Methods For  implementation in Imp. interface   */
	
	/**
	* 
	* @param ID
	* @return
	*/
	public Project get(int ID);
	
	/**
	 * 
	 * @param ProjectID
	 * @return
	 */
	public Project get(String ProjectName);
	/**
	 * @param Company
	 * @return
	 */
	public List <Project> getCompnay(Company Campanyname );
	
	/**
	 * @param Start,Limit
	 * @return
	 */
	
	public List <Project> getAll(int start, int limit);
	
	/**
	 * @return
	 */
	public List <Project> getAll();
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public int save(Project object) ;
	
	/**
	 * 
	 * @param object
	 * @  
	 */
	public void delete(Project object)  ;
	/**
	 * 
	 * @param object
	 * @  
	 */
	public void update(Project object)  ;
	/**
	 * @return
	 */
	public List<String> getAllNames();
	

}

