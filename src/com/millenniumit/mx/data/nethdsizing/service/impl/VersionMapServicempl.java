package com.millenniumit.mx.data.nethdsizing.service.impl;


import java.util.List;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
import com.millenniumit.mx.data.nethdsizing.service.VersionMapService;
import com.millenniumit.mx.data.nethdsizing.dao.VersionMapDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.VersionMapDaoImpl;

/**
 * 
 * @author Raminda
 *
 */
public class  VersionMapServicempl  implements  VersionMapService {

	
	private VersionMapDao Version_MapDao;

	protected VersionMapServicempl() {
	}

	/**
	 * @return the Version_MapsDeo
	 */
	public VersionMapDao getVersion_MapsDao() {
		return Version_MapDao;
	}

	/**
	 * @param Version_MapsDeo the Version_MapsDeo to set
	 */
	public void setVersion_MapsDao(VersionMapDao VersionMapDao) {
		this.Version_MapDao = VersionMapDao;
	}
	public VersionMapServicempl(SessionFactory SessionFactory){
		Version_MapDao=new VersionMapDaoImpl(SessionFactory);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#getVersion_Maps(java.lang.Long)
	 */
	@Override
	public VersionMap get(int id) {
		return getVersion_MapsDao().get(id);
	}


	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#getVersion_Maps()
	 */
	@Override
	public List<VersionMap> getVersion_Maps() {
		return getVersion_MapsDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	public List <VersionMap> getVersion_Maps(int start, int limit) {
		return getVersion_MapsDao().getAll(start, limit);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#saveVersion_Maps(com.millenniumit.mx.data.VersionMap.domain.Version_Maps)
	 */
	@Override
	public int save(VersionMap index) {
		return getVersion_MapsDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#deleteVersion_Maps(com.millenniumit.mx.data.VersionMap.domain.Version_Maps)
	 */
	@Override
	public void delete(VersionMap index) {
		getVersion_MapsDao().delete(index);		
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.Version_MapsService#update(com.millenniumit.mx.data.itic.domain.Version_Maps)
	 */
	@Override
	public void update(VersionMap index) {
		getVersion_MapsDao().update(index);
		
	}

	@Override
	public VersionMap getVersion_Maps(String Version_MapsName) {
		
		return null;
	}

	@Override
	public List<VersionMap> getCompany(Company company) {
		
		return null;
	}

	@Override
	public List<String> getAllNames() {
		
		return null;
	}

}
