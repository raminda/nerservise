package com.millenniumit.mx.data.Session;

import org.hibernate.cfg.AnnotationConfiguration;

public class ConfigAnnotation {
	private AnnotationConfiguration config;
	
	public ConfigAnnotation(){
		config =new AnnotationConfiguration();
	}
	public AnnotationConfiguration AddAnnotaion(){	
		return config;
	}
}
