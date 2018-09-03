package com.metacube.advertismentWebServices.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.metacube.advertismentWebServices.entity.Category;
import com.metacube.advertismentWebServices.enums.Status;
import com.metacube.advertismentWebServices.facade.CategoryFacade;

@Path("/CategoryResource")
public class CategoryResource {

	CategoryFacade categoryFacade = CategoryFacade.getInstance();
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createCategory(Category category){
		Status status  = categoryFacade.createCategory(category);
		if(status == Status.INSERTED){
			return "Successfully created";
		}
		if(status == Status.DUPLICATE){
			return "duplicate category name";
		}
		
		return "error";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories(){
		return categoryFacade.getAll();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateCategoryNameByCategoryId(@PathParam("name") String name, @PathParam("id") int id){
		
		Status status = categoryFacade.updateCategoryNameByCategoryId(name, id);
		
		if(status == Status.UPDATED){
			return "Successfully updated";
		}
		if(status == Status.NOT_FOUND){
			return "No such id to update";
		}
		
		return "error";
	}
}
