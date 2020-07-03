package com.mnd.gunreview.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mnd.gunreview.dto.PX;

@Mapper
public interface PXDAO {
	public List<PX> selectAllProduct();
	public List<PX> selectProductByPeriod(int year, int month);
}
