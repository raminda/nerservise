package com.millenniumit.mx.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * 
 * @author Raminda
 *
 */
public class Sfactory {
	
	private ConfigAnnotation ClassConfig;
	private AnnotationConfiguration Config;
	private SessionFactory SessionFactory;
	/**
	 * 
	 */
	public Sfactory() {
		/* Annotation */
		ClassConfig=new ConfigAnnotation();
		Config=ClassConfig.AddAnnotaion();
		String ConfigXml="hibernate.cfg.xml";
		
		
		/*this line is not need*/
		Config.configure(ConfigXml);
		try {
			SessionFactory=Config.buildSessionFactory();
		} catch (Exception e) {
			createTble();
		}
	}
	
	public void createTble(){
		new SchemaExport(Config).create(true, true);
	}
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.SessionFactory = sessionFactory;
	}
	
}
