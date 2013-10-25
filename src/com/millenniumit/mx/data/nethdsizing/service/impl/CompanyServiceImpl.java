
package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.util.List;
import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.nethdsizing.dao.CompanyDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.CompanyDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.service.CompanyService;
/**
 * 
 * @author Raminda
 *
 */
public class  CompanyServiceImpl implements  CompanyService {

	private CompanyDao CompanyDao;
	protected CompanyServiceImpl() {
	}


	public CompanyServiceImpl(SessionFactory SessionFactory){
		CompanyDao=new CompanyDaoImpl(SessionFactory);
	}
	

	/**
	 * @return {@link CompanyDao}
	 */
	public CompanyDao getCompanyDao() {
		return CompanyDao;
	}

	/**
	 * @param  {@link CompanyDao}
	 */
	public void setCompanyDao(CompanyDao CompanyDao) {
		this.CompanyDao = CompanyDao;
	}

	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #get(int)}
*/
	public Company get(int ID) {
		return getCompanyDao().get(ID);
	}

	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #getAll(int, int)}
	 */
	public  List<Company> getAll(int start ,int limit) {
		return getCompanyDao().getAll(start, limit);
	}
/**
 * @see 'CompanyServiceImpl{@link #get(String)}
 */
	public  Company get(String CompanyName) {
		return getCompanyDao().get(CompanyName);
	}
	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #getAll()}
	 */
	public List<Company> getAll() {
		return getCompanyDao().getAll();
	}
	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #save(Company)}
	 */
	public int save(Company index){
		return getCompanyDao().save(index);
	}

	/** (non-Javadoc)
	 * @throws Exception 
	 * @see `CompanyServiceImpl{@link #update(Company)}
	 */
	public void delete(Company index) {
		getCompanyDao().delete(index);		
	}

/**
 * @throws Exception 
 * @see `CompanyServiceImpl{@link #update(Company)}
 */
	public void update(Company index){
		getCompanyDao().update(index);
		
	}
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
	}

}
