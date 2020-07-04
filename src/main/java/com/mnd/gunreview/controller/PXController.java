package com.mnd.gunreview.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnd.gunreview.dto.PX;
import com.mnd.gunreview.dto.ReviewPX;
import com.mnd.gunreview.service.PXService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/px")
public class PXController {

	private static final Logger logger = LoggerFactory.getLogger(PXController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private PXService pxService;

  @ApiOperation(value = "PX의 모든 상품의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<PX>> selectAllProduct() throws Exception {
		logger.debug("selectAllProduct - 호출");
		return new ResponseEntity<List<PX>>(pxService.selectAllProduct(), HttpStatus.OK);
	}

  @ApiOperation(value = "장소 ID에 해당하는 정보를 반환한다.", response = PX.class)    
	@GetMapping("{year}/{month}")
	public ResponseEntity<List<PX>> selectProductByPeriod(@PathVariable int year, int month) {
		logger.debug("selectProductByPeriod - 호출");
		return new ResponseEntity<List<PX>>(pxService.selectProductByPeriod(year, month), HttpStatus.OK);
	}
}