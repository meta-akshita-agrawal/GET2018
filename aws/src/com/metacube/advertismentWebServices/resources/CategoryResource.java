package com.metacube.advertismentWebServices.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.metacube.advertismentWebServices.entity.Category;
import com.metacube.advertismentWebServices.enums.Status;
import com.metacube.advertismentWebServices.facade.CategoryFacade;

@Path("/CategoryResource")
public class CategoryResource {

	CategoryFacade categoryFacade = CategoryFacade.getInstance();

	/**
	 * Creates a category
	 * @param category
	 * @return status response
	 */
	@POST
	@Path("/createCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCategory(Category category) {

		if (category == null) {
			return Response.serverError().entity("ID cannot be blank").build();
		}

		Status status = categoryFacade.createCategory(category);

		if (status == Status.INSERTED) {
			return Response.ok("Successfully Inserted", MediaType.APPLICATION_JSON).build();
		}

		else {
			return Response.status(Response.Status.CREATED).entity("Entity not Created").build();
		}
	}

	/**
	 * Gets all categories
	 * @return list of categories in JSON format
	 */
	@GET
	@Path("/getAllCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories() {
		List<Category> categoryList = categoryFacade.getAll();

		Gson gson = new Gson();
		String categoryJson = gson.toJson(categoryList);
		return Response.ok(categoryJson, MediaType.APPLICATION_JSON).build();
	}

	/**
	 * Updates category name
	 * @param name
	 * @param id
	 * @return status response
	 */
	@PUT
	@Path("/updateCategoryNameById/{id}/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategoryNameByCategoryId(@PathParam("name") String name, @PathParam("id") int id) {

		if (id == 0 || name == null) {

			return Response.serverError().entity("input parameters cannot be blank").build();
		}

		Status status = categoryFacade.updateCategoryNameByCategoryId(name, id);

		if (status == Status.UPDATED) {
			return Response.ok("Successfully Updated", MediaType.APPLICATION_JSON).build();
		}

		else {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not Created").build();

		}

	}
}
