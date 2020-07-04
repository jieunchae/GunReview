package com.mnd.gunreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnd.gunreview.dao.WelfareDAO;
import com.mnd.gunreview.dto.Welfare;
@Service
public class WelfareServiceImpl implements WelfareService {

	@Autowired
	private WelfareDAO welfareDao;
	@Override
	public List<Welfare> selectWelfare() {
		return welfareDao.selectWelfare();
	}
	@Override
	public Welfare selectWelfareById(String id) {
		return welfareDao.selectWelfareById(id);
	}
	@Override
	public int insertWelfare(Welfare welfare) {
		return welfareDao.insertWelfare(welfare);
	}
	@Override
	public int updateWelfare(Welfare welfare) {
		return welfareDao.updateWelfare(welfare);
	}
	@Override
	public int deleteWelfare(String id) {
		return welfareDao.deleteWelfare(id);
	}

}
