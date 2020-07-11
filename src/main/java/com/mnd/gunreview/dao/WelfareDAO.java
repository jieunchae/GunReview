package com.mnd.gunreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnd.gunreview.dto.Welfare;

@Mapper
public interface WelfareDAO {
	public List<Welfare> selectWelfare();
	public Welfare selectWelfareById(String id);
	public int insertWelfare(Welfare welfare);
	public int updateWelfare(Welfare welfare);
	public int deleteWelfare(String id);
	public int updateWelfareRate(String id);
}
