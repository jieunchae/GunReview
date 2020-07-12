package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.InfoProductDAO;
import com.mnd.gunreview.dto.InfoProduct;

@Service
public class InfoProductServiceImpl implements InfoProductService {

	@Autowired
	private InfoProductDAO infoProductDao;
	
	@Override
	public List<InfoProduct> selectAllProduct() {
		return infoProductDao.selectAllProduct();
	}

	@Override
	public int updateDetail(String name, String detail) {
		return infoProductDao.updateDetail(name, detail);
	}

	@Override
	public int updatePrice(String name, int price) {
		return infoProductDao.updatePrice(name, price);
	}

	@Override
	public int updateSumRate(String review_productname) {
		return infoProductDao.updateSumRate(review_productname);
	}

	@Override
	public int updateNum(String review_productname) {
		return infoProductDao.updateNum(review_productname);
	}

	@Override
	public int updateImg(String review_productname) {
		return infoProductDao.updateImg(review_productname);
	}

	@Override
	public InfoProduct selectProductByName(String review_productname) {
		return infoProductDao.selectProductByName(review_productname);
	}

}
