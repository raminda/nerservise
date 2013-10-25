package com.millenniumit.mx.data.nethdsizing.dao;


import java.util.List;


import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.ProjectItems;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;


/**
 * 
 * @author DECANS
 *
 */
public interface ProjectItemsDao extends Dao <ProjectItems> {
	
				/* Methods For  implementation in Imp. interface   */
		
	/**
	* 
	* @param ID
	* @return
	*/
	public ProjectItems get(int ID);
	
	/**
	 * @param VersionID
	 * @return
	 */
	public List<ProjectItems> getAll(VersionMap VersionID);
	
	/**
	 * @param VersionID
	 * @param SiteID
	 * @return
	 */
	public List<ProjectItems> getAll( VersionMap VersionID, String SiteID);
	
	/**
	 * @param VersionID
	 * @param SiteID
	 * @param PackageID
	 * @return
	 */
	public ProjectItems get(VersionMap VersionID,String SiteID,Packages PackageID);
		
	/**
	 * @param Start,Limit
	 * @return
	 */
	public List<ProjectItems> getAll(int start, int limit);
	
	/**
	 * @return
	 */
	public List<ProjectItems> getAll();
	/**
	 * @param VersionID
	 * @param SiteID
	 * @param PackageType
	 * @return
	 */
	public List<ProjectItems> getAll( VersionMap VersionID,
			String SiteID, String PackageType);

	/**
	 * @param VersionID
	 * @return
	 */
	public List<ProjectItems> getAlldtl(VersionMap VersionID);
	
	
	/* pass string values */
	
	/**
	 * @param VersionID
	 * @param SiteID
	 * @return
	 */
	public List<String> getAllPackage( VersionMap VersionID, String SiteID);

	/**
	 * @param VersionID
	 * @return
	 */
	public List<String> getAllSites( VersionMap VersionID);

	/**
	 * @param VersionID
	 * @return
	 */
	public List<String> getAllPackagetype( VersionMap VersionID,String SiteID);

	/**
	 * 
	 * @param object
	 * @return
	 */
	
	public int save(ProjectItems object) ;
	
	/**
	 * 
	 * @param object
	 */
	public void delete(ProjectItems object) ;
	
	 /* 
	 * @param object
	 * @  
	 */
	public void update(ProjectItems object)  ;

}


