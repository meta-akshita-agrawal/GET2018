package com.metacube.advertismentWebServices.dao;

import java.util.List;

import com.metacube.advertismentWebServices.entity.Advertisement;

//EXTENDING BASE DAO WITH ADDITIONAL METHODS
public interface AdvertisementDao extends BaseDao<Advertisement>{

	
	public List<Advertisement> getAdvertisementsByCategoryId(int id);
	public int deleteAdvertisementById(int id);
}
