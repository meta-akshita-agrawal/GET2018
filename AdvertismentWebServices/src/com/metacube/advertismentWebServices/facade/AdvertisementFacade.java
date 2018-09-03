package com.metacube.advertismentWebServices.facade;

import java.util.List;

import com.metacube.advertismentWebServices.dao.AdvertisementDao;
import com.metacube.advertismentWebServices.dao.MySQLAdvertisementDao;
import com.metacube.advertismentWebServices.entity.Advertisement;
import com.metacube.advertismentWebServices.enums.Status;

public class AdvertisementFacade {

	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();

	AdvertisementDao advertisementDao = MySQLAdvertisementDao.getInstance();

	/**
	 * 
	 * @return
	 */
	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Advertisement> getAllAdvertisements() {
		return advertisementDao.getAll();
	}

	/**
	 * 
	 * @param advertisement
	 * @return
	 */
	public Status createAdvertisement(Advertisement advertisement) {

		List<Advertisement> advertisementList = advertisementDao.getAll();
		int result = advertisementDao.insert(advertisement);

		if (result == 1) {
			return Status.INSERTED;
		}

		for (Advertisement tempAdvertisement : advertisementList) {
			if (tempAdvertisement.getTitle().equals(advertisement.getTitle())) {
				return Status.DUPLICATE;
			}
		}

		return Status.ERROR;

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Advertisement> getAdvertisementsByCategoryId(int id) {
		return advertisementDao.getAdvertisementsByCategoryId(id);
	}

	/**
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public Status updateAdvertisementNameByCategoryId(String name, int id) {

		int result = advertisementDao.updateNameById(name, id);

		if (result == 1) {
			return Status.UPDATED;
		}
		return Status.NOT_FOUND;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Status deleteAdvertisementById(int id) {

		int result = advertisementDao.deleteAdvertisementById(id);
		if (result == 1) {
			return Status.DELETED;
		}
		return Status.NOT_FOUND;
	}
}
