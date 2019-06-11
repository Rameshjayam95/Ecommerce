package com.bazzar.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bazzar.DAO.CategoryDao;
import com.bazzar.DAO.ProductDao;
import com.bazzar.DAO.SupplierDao;
import com.bazzar.model.Category;
import com.bazzar.model.Product;
import com.bazzar.model.Supplier;

@Controller
public class ProductController
{
@Autowired
ProductDao productDAO;

@Autowired
CategoryDao categoryDAO;

@Autowired
SupplierDao supplierDAO;

@RequestMapping(value="/product")
public String showProductPage(Model m)
{
	Product product=new Product ();
	m.addAttribute("product",product);	
	
	List<Product> productList=productDAO.listProduct();
	m.addAttribute("productList",productList);
	
	List<Category> categoryList=categoryDAO.listCategories();
	m.addAttribute("categoryList",this.getCategoryList(categoryList));
	
	List<Supplier> supplierList=supplierDAO.listSupplier();
    m.addAttribute("supplierList",this.getSupplierList(supplierList));
    
    return "Product";	
	}
public LinkedHashMap<Integer,String>getCategoryList(List<Category>categoryList)
{
	LinkedHashMap<Integer,String> listCategory=new LinkedHashMap<Integer,String>();
	
	int i=0;
	while(i<categoryList.size())
	{
		Category category=categoryList.get(i);
		listCategory.put(category.getCategoryId(),category.getCategoryNames());
		i++;
	}
	return listCategory;
}
public LinkedHashMap<Integer,String>getSupplierList(List<Supplier>supplierList)
{
     LinkedHashMap<Integer,String> listSupplier=new LinkedHashMap<Integer,String>();
     int i=0;
     while(i<supplierList.size())
     {
    	 Supplier supplier = supplierList.get(i);
    	 listSupplier.put(supplier.getSupplierId(), supplier.getSupplierName());
    	 i++;
     }
	 return listSupplier;
}
    @RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
    public String InsertProduct(@ModelAttribute("product")Product product1,@RequestParam("pimage")MultipartFile fileImage,Model m)
    {
    	productDAO.addProduct(product1);
    	
    	//Adding the Image
		
    			String path="C:\\Users\\Home\\eclipse-workspace\\GiveawayFrontend\\src\\main\\webapp\\resources\\images\\";
    			path=path+String.valueOf(product1.getProductId())+".jpg";
    			File imageFile=new File(path);
    			
    			if(!fileImage.isEmpty())
    			{
    				try
    				{
    					byte[] buffer=fileImage.getBytes();
    					FileOutputStream fos=new FileOutputStream(imageFile);
    					BufferedOutputStream bs=new BufferedOutputStream(fos);
    					bs.write(buffer);
    					bs.close();
    				}
    				catch(Exception e)
    				{
    					System.out.println("Exception Arised:"+e);
    				}
    			}
    			else
    			{
    				System.out.println("Error Occured:");
    			}
    	
    	List<Product> productList=productDAO.listProduct();
    	m.addAttribute("productList",productList);
    	
    	Product product=new Product();
    	m.addAttribute("product",product);
    	
    	List<Category> categoryList=categoryDAO.listCategories();
    	m.addAttribute("categoryList",this.getCategoryList(categoryList));
    	
    	List<Supplier> supplierList=supplierDAO.listSupplier();
        m.addAttribute("supplierList",this.getSupplierList(supplierList));
        
        return "Product";       
    }
    @RequestMapping(value="/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId")int productId,Model m)
    {
    	Product product1=productDAO.getProduct(productId);
    	productDAO.deleteProduct(product1);
    	
    	List<Product> productList=productDAO.listProduct();
    	m.addAttribute("productList",productList);
    	
    	Product product=new Product();
    	m.addAttribute("product", product);
    	
    	List<Category> categoryList=categoryDAO.listCategories();
    	m.addAttribute("categoryList",this.getCategoryList(categoryList));
    	
    	List<Supplier> supplierList=supplierDAO.listSupplier();
        m.addAttribute("supplierList",this.getSupplierList(supplierList));
        
        return "Product";
    }
    @RequestMapping(value="/editproduct/{productId}")
    public String editProduct(@PathVariable("productId")int productId,Model m)
    {
    	Product product1=productDAO.getProduct(productId);
    	m.addAttribute("product",product1);
    	
    	List<Category> categoryList=categoryDAO.listCategories();
    	m.addAttribute("categoryList",this.getCategoryList(categoryList));
    	
    	List<Supplier> supplierList=supplierDAO.listSupplier();
        m.addAttribute("supplierList",this.getSupplierList(supplierList));
        return "updateProduct";
    }
    @RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
    public String UpdateProduct(@ModelAttribute("product")Product product1,Model m)
    {
    productDAO.updateProduct(product1);
    
    List<Product> productList=productDAO.listProduct();
	m.addAttribute("productList",productList);
	
	Product product= new Product();
	m.addAttribute("product",product);
	
	List<Category> categoryList=categoryDAO.listCategories();
	m.addAttribute("categoryList",this.getCategoryList(categoryList));
	
	List<Supplier> supplierList=supplierDAO.listSupplier();
    m.addAttribute("supplierList",this.getSupplierList(supplierList));
	
    return "Product";    	
    }
    @RequestMapping(value="/productPage")
    public String displayProductDisplay(Model m)
    {
    	List<Product> productList=productDAO.listProduct();
    	m.addAttribute("productList",productList);
    	return "ProductPage";
    }
    @RequestMapping(value="totalProductDisplay/{productId}")
    public String totalProductDisplay(@PathVariable("productId")int productId,Model m)
    {
    	Product product1=productDAO.getProduct(productId);
    	m.addAttribute("product",product1);
    	return "totalProductDisplay";
    }
    }
