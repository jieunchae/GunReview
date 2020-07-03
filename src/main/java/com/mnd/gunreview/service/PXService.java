package com.mnd.gunreview.service;

import java.util.List;
import com.mnd.gunreview.dto.PX;

public interface PXService {
	public List<PX> selectAllProduct();
	public List<PX> selectProductByPeriod(int year, int month);
}
