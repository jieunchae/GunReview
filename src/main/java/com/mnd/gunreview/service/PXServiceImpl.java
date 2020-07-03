package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnd.gunreview.dao.PXDAO;
import com.mnd.gunreview.dto.PX;

@Service
public class PXServiceImpl implements PXService {

	@Autowired
	private PXDAO PXDao;
	
	@Override
	public List<PX> selectAllProduct() {
		return PXDao.selectAllProduct();
	}

	@Override
	public List<PX> selectProductByPeriod(int year, int month) {
		return PXDao.selectProductByPeriod(year, month);
	}

}
