package com.bazzar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bazzar.DAO.CategoryDao;
import com.bazzar.model.Category;

@Controller
public class CategoryController
{
     @Autowired
     CategoryDao categoryDAO;
     
     @RequestMapping(value="/category")
     public String showCategoryPage(Model m)
     {
    	 List<Category> categoryList=categoryDAO.listCategories();
    	 m.addAttribute(categoryList);
    	 return "Category";
     }
     @RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
     public String InsertCategory(@RequestParam("CategoryNames")String CategoryNames,@RequestParam("CategoryDesc")String CategoryDesc,Model m)
{
    	 Category category=new Category();
    	 category.setCategoryNames(CategoryNames);
    	 category.setCategoryDesc(CategoryDesc);
    	 
    	 categoryDAO.addCategory(category);
    	 
    	 List<Category> categoryList=categoryDAO.listCategories();
    	 m.addAttribute("categoryList",categoryList);
    	 return "Category";          	 
}
     @RequestMapping(value="/editCategory/{categoryId}")
     public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
     {
          Category category=categoryDAO.getCategory(categoryId);
          m.addAttribute("category", category);
          return "UpdateCategory";
     }
     @RequestMapping(value="/deleteCategory/{categoryId}")
     public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
     {
    	 Category category=categoryDAO.getCategory(categoryId);
    	 categoryDAO.deleteCategory(category);
    	 
    	 List<Category> categoryList=categoryDAO.listCategories();
    	 m.addAttribute("categoryList",categoryList);
    	 return "Category";   
     }
     
     @RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
     public String updateCategory(@RequestParam("CategoryId") int categoryId,@RequestParam("CategoryNames")String CategoryNames,@RequestParam("CategoryDesc")String CategoryDesc,Model m)
     {
    	 Category category=categoryDAO.getCategory(categoryId);
    	 category.setCategoryNames(CategoryNames);
    	 category.setCategoryDesc(CategoryDesc);
    	 
    	 categoryDAO.updateCategory(category);
    	 
    	 List<Category> categoryList=categoryDAO.listCategories();
    	 m.addAttribute("categoryList",categoryList);
    	 return "Category";
     }
}