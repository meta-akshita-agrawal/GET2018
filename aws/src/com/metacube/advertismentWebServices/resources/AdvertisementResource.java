package com.metacube.advertismentWebServices.resources;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.metacube.advertismentWebServices.entity.Advertisement;
import com.metacube.advertismentWebServices.facade.AdvertisementFacade;
import com.metacube.advertismentWebServices.enums.*;

@Path("/Advertisement")
public class AdvertisementResource {

	AdvertisementFacade advertisementFacade = AdvertisementFacade.getInstance();

	
	/**
	 * Creates advertisement
	 * @param advertisement
	 * @return status response
	 */
	@POST
	@Path("/createAdvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAdvertisement(Advertisement advertisement) {

		if (advertisement == null) {
			return Response.serverError().entity("input cannot be blank").build();
		}

		Status status = advertisementFacade.createAdvertisement(advertisement);

		if (status == Status.INSERTED) {
			return Response.ok("Inserted Successfully", MediaType.APPLICATION_JSON).build();

		} else {
			return Response.status(Response.Status.BAD_REQUEST).entity("Entity not found ").build();
		}

	}

	/**
	 * Gets all advertisements
	 * @return list of advertisements in JSON format
	 */
	@GET
	@Path("/advertisements")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdvertisements(){

		List<Advertisement> advList = advertisementFacade.getAllAdvertisements();

		Gson gson = new Gson();
		String advertismnetJson = gson.toJson(advList);
		return Response.ok(advertismnetJson, MediaType.APPLICATION_JSON).build();

	}

	/**
	 * Deletes an advertisement on the corresponding id
	 * @param id
	 * @return status response
	 */
	@DELETE
	@Path("/deleteAdvertisementById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdvertisementById(@PathParam("id") int id) {

		if (id == 0) {
			return Response.serverError().entity("Input parameters cannot be blank").build();
		}

		Status status = advertisementFacade.deleteAdvertisementById(id);

		if (status == Status.DELETED) {
			return Response.ok("Successfully Deleted", MediaType.TEXT_PLAIN).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for id: " + id).build();
		}

	}

	/**
	 * Updates advertisement name 
	 * @param title
	 * @param id
	 * @return status response
	 */
	@PUT
	@Path("/updateAdvertisementNameById/{id}/{title}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAdvertisementNameByCategoryId(@PathParam("title") String title, @PathParam("id") int id) {

		if (id == 0 || title == null) {
			return Response.serverError().entity("Input parameters cannot be blank").build();
		}

		Status status = advertisementFacade.updateAdvertisementNameById(title, id);

		if (status == Status.UPDATED) {
			return Response.ok("Successfully updated", MediaType.TEXT_PLAIN).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for id: " + id).build();
		}

	}

	/**
	 * Gets all advertisements corresponding to the category
	 * @param id
	 * @return status response
	 */
	@GET
	@Path("/getAdvertisementsByCategoryId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdvertisementsByCategoryId(@PathParam("id") int id) {

		if (id == 0) {
			return Response.serverError().entity("ID cannot be blank").build();
		}
		List<Advertisement> advList = advertisementFacade.getAdvertisementsByCategoryId(id);

		if (advList.size() == 0) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for Id: " + id).build();
		} else {
			Gson gson = new Gson();
			String advertismnetJson = gson.toJson(advList);
			return Response.ok(advertismnetJson, MediaType.APPLICATION_JSON).build();
		}

	}

}
