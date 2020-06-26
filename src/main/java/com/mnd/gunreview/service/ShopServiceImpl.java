package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.ShopDAO;
import com.mnd.gunreview.dto.Shop;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDAO shopDao;

	@Override
	public List<Shop> selectShop() {
		return shopDao.selectShop();
	}

	@Override
	public Shop selectShopById(String id) {
		return shopDao.selectShopById(id);
	}

	@Override
	public int insertShop(Shop shop) {
		return shopDao.insertShop(shop);
	}

	@Override
	public int updateShop(Shop shop) {
		return shopDao.updateShop(shop);
	}

	@Override
	public int deleteShop(String id) {
		return shopDao.deleteShop(id);
	}
}
