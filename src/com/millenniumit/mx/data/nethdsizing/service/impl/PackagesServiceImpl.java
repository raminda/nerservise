package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.sql.Date;
import java.util.List;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.dao.PackagesDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.PackagesDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.service.PackagesService;

/**
 * 
 * @author Raminda
 *
 */
public class PackagesServiceImpl implements PackagesService {

	private PackagesDao PackagesDao;

	protected PackagesServiceImpl() {
	}

	/**
	 * @return the PackagesDeo
	 */
	public PackagesDao getPackagesDao() {
		return PackagesDao;
	}

	/**
	 * @param PackagesDeo the PackagesDeo to set
	 */
	public void setPackagesDao(PackagesDao PackagesDao) {
		this.PackagesDao = PackagesDao;
	}
	public PackagesServiceImpl(SessionFactory SessionFactory) {
	PackagesDao=new PackagesDaoImpl(SessionFactory);
	}
	@Override
	public Packages getPackagess(int ID) {
		return getPackagesDao().get(ID);
	}

	@Override
	public Packages getPackages(String Packages) {
		return getPackagesDao().get(Packages);
	}

	@Override
	public List<Packages> getPackages() {
		return getPackagesDao().getAll();
	}

	@Override
	public List<Packages> getPackages(int start, int limit) {
		return getPackagesDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.SiteTypeService#deleteSiteType(com.millenniumit.mx.data.ITIC.domain.SiteType)
	 */

	@Override
	public List<Packages> getAll(Date date, int Type) {
		return getPackagesDao().getAll(date, Type);
	}

	@Override
	public List<Packages> getAll(Date date1, Date date2) {
		return getPackagesDao().getAll(date1, date2);
	}
	
	@Override
	public int save(Packages index) {
		return getPackagesDao().save(index);
	}

	@Override
	public void delete(Packages index) {
		getPackagesDao().delete(index);
		
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.PackagesService#update(com.millenniumit.mx.data.itic.domain.Packages)
	 */
	@Override
	public void update(Packages index) {
		getPackagesDao().update(index);
		
	}



}
