package com.metacube.advertismentWebServices.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.metacube.advertismentWebServices.entity.Advertisement;
import com.metacube.advertismentWebServices.facade.AdvertisementFacade;
import com.metacube.advertismentWebServices.enums.*;

@Path("/Advertisement")
public class AdvertisementResource {

	AdvertisementFacade advertisementFacade = AdvertisementFacade.getInstance();
	public AdvertisementResource()
	{}

	
	@PUT
	@Path("/createAdvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createAdvertisement(Advertisement advertisement){
		Status status  = advertisementFacade.createAdvertisement(advertisement);
		if(status == Status.INSERTED){
			return "Successfully created";
		}
		if(status == Status.DUPLICATE){
			return "duplicate category name";
		}
		
		return "error";
	}
	

	@GET
	@Path("/advertisements")
	@Produces("application/json")
	public List<Advertisement> getAllAdvertisements(){
		return advertisementFacade.getAllAdvertisements();
	}
	
	@GET
	@Path("/advertisements1")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisements1(){
		return "test";
	}
	
	
	@DELETE
	@Path("/deleteAdvertisementById")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAdvertisementById(@PathParam("id") int id){
		Status status = advertisementFacade.deleteAdvertisementById(id);
		
		if(status == Status.DELETED){
			return "Successfully deleted";
		}
		if(status == Status.NOT_FOUND){
			return "No such id";
		}
		
		return "error";
	}
	
	@PUT
	@Path("updateAdvertisementNameByCategoryId")
	@Consumes(MediaType.APPLICATION_JSON)
	public String  updateAdvertisementNameByCategoryId(@PathParam("title") String title, @PathParam("id") int id){
		
		Status status = advertisementFacade.updateAdvertisementNameByCategoryId(title, id);
		
		if(status == Status.UPDATED){
			return "Successfully updated";
		}
		if(status == Status.NOT_FOUND){
			return "No such id to update";
		}
		
		return "error";
		
	}
	
	@GET
	@Path("getAdvertisementsByCategoryId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAdvertisementsByCategoryId(@PathParam("id") int id){
		return advertisementFacade.getAdvertisementsByCategoryId(id);
	}
	
}
