package com.bazzar.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bazzar.DAO.SupplierDao;
import com.bazzar.model.Supplier;

@Controller
public class SupplierController 
{
   @Autowired
   SupplierDao supplierDAO;
   
   @RequestMapping(value="/supplier")
   public String showSupplierpage(Model m)
   {
       List<Supplier> supplierList=supplierDAO.listSupplier();
       m.addAttribute(supplierList);
       return "Supplier";
   }
   @RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
   public String InsertSupplier(@RequestParam("supplierName")String supplierName,@RequestParam("suppAddr")String suppAddr, Model m)
   {
	   Supplier supplier=new Supplier();
	   supplier.setSupplierName(supplierName);
	   supplier.setSuppAddr(suppAddr);
	   
	   supplierDAO.addsupplier(supplier);
	    
	   List<Supplier> supplierList=supplierDAO.listSupplier();
	   m.addAttribute("supplierList",supplierList);
	   
	   return "Supplier";
   }
   
   @RequestMapping(value="/editSupplier/{supplierId}")
   public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
   {
	   Supplier supplier=supplierDAO.getSupplier(supplierId);
	   m.addAttribute("supplier", supplier);
	   List<Supplier> supplierList=supplierDAO.listSupplier();
	   m.addAttribute("supplierList",supplierList);
	   return "UpdateSupplier";
   }
@RequestMapping(value="/deleteSupplier/{supplierId}")
public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
{
	Supplier supplier=supplierDAO.getSupplier(supplierId);
	supplierDAO.deletesupplier(supplier);
	
	   List<Supplier> supplierList=supplierDAO.listSupplier();
	   m.addAttribute("supplierList",supplierList);
	   
	return "Supplier";

}
@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
public String updateSupplier(@RequestParam("supplierId")int supplierId, @RequestParam("supplierName")String supplierName,@RequestParam("suppAddr")String suppAddr,Model m)
{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
	   supplier.setSupplierName(supplierName);
	   supplier.setSuppAddr(suppAddr);
	   
	   supplierDAO.updatesupplier(supplier);
	   
	   return "Supplier";
	   

	}
}

