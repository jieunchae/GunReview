package com.mnd.gunreview.service;

import java.util.List;

import com.mnd.gunreview.dto.Welfare;

public interface WelfareService {
	public List<Welfare> selectWelfare();
	public Welfare selectWelfareById(String id);
	public int insertWelfare(Welfare welfare);
	public int updateWelfare(Welfare welfare);
	public int deleteWelfare(String id);
	public int updateWelfareRate(String id);
}
