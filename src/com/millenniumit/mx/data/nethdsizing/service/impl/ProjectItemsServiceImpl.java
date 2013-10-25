package com.millenniumit.mx.data.nethdsizing.service.impl;

//import java.sql.Date;
import java.util.List;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.dao.ProjectItemsDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.ProjectItemsDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.ProjectItems;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
import com.millenniumit.mx.data.nethdsizing.service.ProjectItemsService;

/**
 * 
 * @author Raminda
 *
 */
public class ProjectItemsServiceImpl  implements ProjectItemsService {

	private  ProjectItemsDao  projectItemsDao;
	
	protected ProjectItemsServiceImpl() {
	}

	/**
	 * @return the PackagesDeo
	 */
	public   ProjectItemsDao getProjectItemsDao() {
		return  projectItemsDao;
	}

	/**
	 * @param PackagesDeo the PackagesDeo to set
	 */
	
	public void setProjectItemsDao( ProjectItemsDao  projectItemsDao) {
		this. projectItemsDao =  projectItemsDao;
	}
	
	public ProjectItemsServiceImpl(SessionFactory SessionFactory){
		projectItemsDao=new ProjectItemsDaoImpl(SessionFactory);
	}
	
	@Override
	public ProjectItems getProjectItemss(int ID) {
		return getProjectItemsDao().get(ID);
	}

	@Override
	public List<ProjectItems> getAll() {
		return getProjectItemsDao().getAll();
	}

	@Override
	public List<ProjectItems> getAll(int start, int limit) {
		return getProjectItemsDao().getAll(start, limit);
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectItemsService#getAll(java.lang.String)
	 */
	@Override
	 
	public List<ProjectItems> getAll(VersionMap VersionID) {
		return getProjectItemsDao().getAll(VersionID);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectItemsService#get(com.millenniumit.mx.data.itic.domain.Projects, java.lang.String, java.lang.String, com.millenniumit.mx.data.itic.domain.SiteType, com.millenniumit.mx.data.itic.domain.Packages)
	 */
	@Override
	public ProjectItems get(VersionMap VersionID, String SiteID, Packages PackageID) {
		
		return getProjectItemsDao().get( VersionID, SiteID, PackageID);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectItemsService#getAll(com.millenniumit.mx.data.itic.domain.Projects, java.lang.String, java.lang.String, com.millenniumit.mx.data.itic.domain.SiteType)
	 */
	@Override 
	public List<ProjectItems> getAll(VersionMap VersionID, String SiteID) {
		
		return getProjectItemsDao().getAll( VersionID, SiteID);
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectItemsService#getAll(com.millenniumit.mx.data.itic.domain.Projects, java.lang.String, java.lang.String)
	 */
	@Override 
	public List<ProjectItems> getAll(VersionMap VersionID,String SiteID,String PacakgeType) {
		
		return getProjectItemsDao().getAll( VersionID,SiteID,PacakgeType);
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectItemsService#getAll(com.millenniumit.mx.data.itic.domain.Projects, java.lang.String, java.lang.String)
	 */
	@Override
	public List <String>  getAllString(VersionMap VersionID,String[] string,int lenth) {
		List <String>st=null; 
		/*if(lenth==1){
			//st=getProjectItemsDao().getAllOption(projects);
		}
		else if(lenth==2){
			//st=getProjectItemsDao().getAllVersion(VersionID, string[0]);
		}
		else */if(lenth==1){
			st=getProjectItemsDao().getAllSites(VersionID);
			
		}
		else if(lenth==2){
			st=getProjectItemsDao().getAllPackage(VersionID, string[0]);
		}
		else if(lenth==3){
			st=getProjectItemsDao().getAllPackagetype(VersionID, string[0]);
		}
		return st;
	}

	@Override
	public List<ProjectItems> getAlldtl(VersionMap VersionID) {
		
		return null;
	}
	
	@Override
	public int save(ProjectItems index) {
		return getProjectItemsDao().save(index);
	}


	@Override 
	public void delete(ProjectItems index) {
		getProjectItemsDao().delete(index);
		
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectItemsService#update(com.millenniumit.mx.data.itic.domain.ProjectItems)
	 */
	@Override
	public void update(ProjectItems index) {
		getProjectItemsDao().update(index);
	}
}
