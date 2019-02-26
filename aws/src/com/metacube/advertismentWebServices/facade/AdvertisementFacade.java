package com.metacube.advertismentWebServices.facade;

import java.util.List;

import com.metacube.advertismentWebServices.dao.AdvertisementDao;
import com.metacube.advertismentWebServices.dao.MySQLAdvertisementDao;
import com.metacube.advertismentWebServices.entity.Advertisement;
import com.metacube.advertismentWebServices.enums.Status;

public class AdvertisementFacade {

	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();

	AdvertisementDao advertisementDao = MySQLAdvertisementDao.getInstance();

	// CREATES SINGLE INSTANCE
	public static AdvertisementFacade getInstance() {
		return advertisementFacade;
	}

	/**
	 * Gets all advertisements
	 * @return list of advertisements
	 */
	public List<Advertisement> getAllAdvertisements() {
		return advertisementDao.getAll();
	}

	/**
	 * Creates a new advertisement
	 * @param advertisement
	 * @return status of the process
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
	 * Gets all advertisements corresponding to the category
	 * @param id, category id
	 * @return list of advertisements
	 */
	public List<Advertisement> getAdvertisementsByCategoryId(int id) {
		return advertisementDao.getAdvertisementsByCategoryId(id);
	}

	/**
	 * Updates advertisement name
	 * @param name
	 * @param id
	 * @return status
	 */
	public Status updateAdvertisementNameById(String name, int id) {

		int result = advertisementDao.updateNameById(name, id);

		if (result == 1) {
			return Status.UPDATED;
		}
		return Status.NOT_FOUND;
	}

	/**
	 * Deletes an advertisement 
	 * @param id, id of advertisement to be deleted
	 * @return status
	 */
	public Status deleteAdvertisementById(int id) {

		int result = advertisementDao.deleteAdvertisementById(id);
		if (result == 1) {
			return Status.DELETED;
		}
		return Status.NOT_FOUND;
	}
}
