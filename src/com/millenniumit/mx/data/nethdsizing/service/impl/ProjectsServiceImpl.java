package com.millenniumit.mx.data.nethdsizing.service.impl;


import java.util.List;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.service.ProjectsService;
import com.millenniumit.mx.data.nethdsizing.dao.ProjectDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.ProjectDaoImpl;

/**
 * 
 * @author Raminda
 *
 */
public class  ProjectsServiceImpl  implements  ProjectsService {


	private ProjectDao ProjectDao;

	protected ProjectsServiceImpl() {
	}

	/**
	 * @return the ProjectsDeo
	 */
	public ProjectDao getProjectsDao() {
		return ProjectDao;
	}

	/**
	 * @param ProjectsDeo the ProjectsDeo to set
	 */
	public void setProjectsDao(ProjectDao ProjectsDao) {
		this.ProjectDao = ProjectsDao;
	}
	public ProjectsServiceImpl(SessionFactory SessionFactory){
		ProjectDao=new ProjectDaoImpl(SessionFactory);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#getProjects(java.lang.Long)
	 */
	@Override
	public Project getProjects(int id) {
		return getProjectsDao().get(id);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#getProjects(java.lang.String)
	 */
	@Override
	public Project getProjects(String ProjectsName) {
		return getProjectsDao().get(ProjectsName);
	}


	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#getProjects()
	 */
	@Override
	public List<Project> getProjects() {
		return getProjectsDao().getAll();
	}
	@Override
	public List <Project> getCompany(Company Campanyname){	
		return getProjectsDao().getCompnay(Campanyname);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	public List <Project> getProjects(int start, int limit) {
		return getProjectsDao().getAll(start, limit);
	}
	@Override
	public List<String> getAllNames() {
		return getProjectsDao().getAllNames();
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#saveProjects(com.millenniumit.mx.data.Project.domain.Projects)
	 */
	@Override
	public int save(Project index) {
		return getProjectsDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#deleteProjects(com.millenniumit.mx.data.Project.domain.Projects)
	 */
	@Override
	public void delete(Project index) {
		getProjectsDao().delete(index);		
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectsService#update(com.millenniumit.mx.data.itic.domain.Projects)
	 */
	@Override
	public void update(Project index) {
		getProjectsDao().update(index);
		
	}

}
