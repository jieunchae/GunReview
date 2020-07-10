package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.Shop;

public interface ShopService {
	public List<Shop> selectShop();
	public Shop selectShopById(String id);
	public int insertShop(Shop shop);
	public int updateShop(Shop shop);
	public int deleteShop(String id);
	public List<Shop> selectShopByLoc(double lat, double lng);
}
