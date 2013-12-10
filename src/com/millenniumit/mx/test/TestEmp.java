/**
 * 
 */
package com.millenniumit.mx.test;


import java.util.Date;

import org.hibernate.SessionFactory;

import com.millenniumit.mx.data.Session.Sfactory;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.service.CompanyService;
import com.millenniumit.mx.data.nethdsizing.service.impl.CompanyServiceImpl;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.domain.ProjectItems;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentMapingService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsBulkService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsService;
import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;
import com.millenniumit.mx.data.nethdsizing.service.PackagesService;
import com.millenniumit.mx.data.nethdsizing.service.ProjectItemsService;
import com.millenniumit.mx.data.nethdsizing.service.ProjectsService;
import com.millenniumit.mx.data.nethdsizing.service.VersionMapService;
import com.millenniumit.mx.data.nethdsizing.service.impl.EquipmentMapingServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.EquipmentBulkServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.EquipmentsServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.ItemTypesServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.PackagesServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.ProjectItemsServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.ProjectsServiceImpl;
import com.millenniumit.mx.data.nethdsizing.service.impl.VersionMapServicempl;

/**
 * @author Raminda
 *
 */
public class TestEmp {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args){
		Date date=new Date();
		Sfactory sfactory=new Sfactory();
		SessionFactory SessionFactory=sfactory.getSessionFactory();
		
		/**
		 * base items
		 */
		ItemTypes itemTypes =new ItemTypes();
		itemTypes.setAccsessLevel(0);
		itemTypes.setTypeName("Base");
		ItemTypesService itemTypesService=new ItemTypesServiceImpl(SessionFactory);
		try {
			itemTypesService.save(itemTypes);
		} catch (Exception e) {
			System.out.println("Item Type  : "+e.getMessage());
		}
		
		Equipments equipments=new Equipments();
		equipments.setItemName("Base");
		equipments.setItemType(itemTypes);
		equipments.setITIC_Descrip("Base");
		equipments.setTec_Descrip("Base");
		equipments.setSummary("Base");
		equipments.setPrice(0);
		equipments.setEOLDate(date);
		EquipmentsService equipmentsService=new EquipmentsServiceImpl(SessionFactory);	
		try {
			equipmentsService.save(equipments);	
		} catch (Exception e) {
			System.out.println("Eq  : "+e.getMessage());
		}
		
		/**
		 * end base
		 */
		
		Company company=new Company();
		company.setCompanyName("nirobi");
		CompanyService companyService= new CompanyServiceImpl(SessionFactory);
		try {
			companyService.save(company);
		} catch (Exception e) {
			System.out.println("company : "+e.getMessage());
		}
	
		itemTypes =new ItemTypes();
		itemTypes.setAccsessLevel(1);
		itemTypes.setTypeName("Ram");
		itemTypesService=new ItemTypesServiceImpl(SessionFactory);
		try {
			itemTypesService.save(itemTypes);
		} catch (Exception e) {
			System.out.println("Item Type  : "+e.getMessage());
		}
		
		itemTypes =new ItemTypes();
		itemTypes.setAccsessLevel(1);
		itemTypes.setTypeName("Server");
		itemTypesService=new ItemTypesServiceImpl(SessionFactory);
		try {
			itemTypesService.save(itemTypes);
		} catch (Exception e) {
			System.out.println("Item Type  : "+e.getMessage());
		}
		
		equipments=new Equipments();
		equipments.setItemName("Kingston");
		equipments.setItemType(itemTypesService.getItemTypess(2));
		equipments.setITIC_Descrip("Eq1 is best");
		equipments.setTec_Descrip("Tec Eq1 is most best");
		equipments.setSummary("best eq in eq1 catagory");
		equipments.setPrice(1000);
		equipments.setEOLDate(date);
		equipmentsService=new EquipmentsServiceImpl(SessionFactory);	
		try {
			equipmentsService.save(equipments);	
		} catch (Exception e) {
			System.out.println("Eq  : "+e.getMessage());
		}	
		
		equipments=new Equipments();
		equipments.setItemName("Server 123");
		equipments.setItemType(itemTypesService.getItemTypess(3));
		equipments.setITIC_Descrip("Eq1 is best");
		equipments.setTec_Descrip("Tec Eq1 is most best");
		equipments.setSummary("best eq in eq1 catagory");
		equipments.setPrice(1000);
		equipments.setEOLDate(date);
		equipmentsService=new EquipmentsServiceImpl(SessionFactory);	
		try {
			equipmentsService.save(equipments);	
		} catch (Exception e) {
			System.out.println("Eq  : "+e.getMessage());
		}	
		
		EquipmentMaping equipmentmaping=new EquipmentMaping();
		equipmentmaping.setParentID(equipmentsService.getEquipments(3));
		equipmentmaping.setChildID(equipmentsService.getEquipments(2));
		EquipmentMapingService equipmentMapingService=new  EquipmentMapingServiceImpl(SessionFactory);
		try {
			equipmentMapingService.save(equipmentmaping);
		} catch (Exception e) {
			System.out.println("Eq Maping  : "+e.getMessage());
		}
	
		Project project=new  Project();
		project.setAmount((long) 1500);
		project.setCompany(companyService.get(1));
		project.setProjectName("Dhilli");
		ProjectsService projectsService=new ProjectsServiceImpl(SessionFactory);
		try {
			projectsService.save(project);
		} catch (Exception e) {
			System.out.println("Project  : "+e.getMessage());
		}
		
		Packages packages=new  Packages();
		packages.setBasePrice(100);
		packages.setComment("Server 1");
		packages.setEOLDate(date);
		packages.setPackageName("Server");
		packages.setSummary("Server");
		PackagesService packagesService=new PackagesServiceImpl(SessionFactory);
		try {
			packagesService.save(packages);
		} catch (Exception e) {
			System.out.println("Package  : "+e.getMessage());
		}
		
		EquipmentBulk equipmentbulk=new EquipmentBulk();
		equipmentbulk.setEquipmentsId(equipmentsService.getEquipments(3));
		equipmentbulk.setPackageID(packagesService.getPackagess(1));
		equipmentbulk.setQuantity(3);
		EquipmentsBulkService equipmentsBulkService=new EquipmentBulkServiceImpl(SessionFactory);
		try {
			equipmentsBulkService.save(equipmentbulk);
		} catch (Exception e) {
			System.out.println("equipmentbulk  : "+e.getMessage());
		}
		
		ProjectItems projectItems=new ProjectItems();
		projectItems.setPackageID(packagesService.getPackagess(1));
		projectItems.setPackageType("Base");
		projectItems.setQuantity(4);
		ProjectItemsService projectItemsService=new ProjectItemsServiceImpl(SessionFactory);
		try {
			projectItemsService.save(projectItems);
		} catch (Exception e) {
			System.out.println("projectItems  : "+e.getMessage());
		}
		
		VersionMap versionMap=new VersionMap();
		versionMap.setOptionID("Op12");
		versionMap.setVersion("sdfsdf");
		versionMap.setSiteID("Main");
		versionMap.setProjectID(projectsService.getProjects(1));
		VersionMapService versionMapService=new VersionMapServicempl(SessionFactory);
		try {
			versionMapService.save(versionMap);
		} catch (Exception e) {
			System.out.println("projectItems  : "+e.getMessage());
		}
	}

}
