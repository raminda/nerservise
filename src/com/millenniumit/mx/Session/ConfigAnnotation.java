package com.millenniumit.mx.Session;

import javax.persistence.Entity;
import org.hibernate.cfg.AnnotationConfiguration;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.domain.ProjectItems;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
import com.millenniumit.mx.data.nethdsizing.domain.columnhandler;

@Entity
public class ConfigAnnotation {
	private AnnotationConfiguration config;
	
	public ConfigAnnotation(){
		config =new AnnotationConfiguration();
	}
	public AnnotationConfiguration AddAnnotaion(){
		
		config.addAnnotatedClass(ItemTypes.class);
		config.addAnnotatedClass(Company.class);
		config.addAnnotatedClass(Packages.class);
		config.addAnnotatedClass(EquipmentBulk.class);
		config.addAnnotatedClass(EquipmentMaping.class);
		config.addAnnotatedClass(Equipments.class);
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(ProjectItems.class);
		config.addAnnotatedClass(VersionMap.class);
		config.addAnnotatedClass(columnhandler.class);
		
		return config;
	}
}
