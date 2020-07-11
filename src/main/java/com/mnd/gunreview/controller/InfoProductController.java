package com.mnd.gunreview.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnd.gunreview.dto.InfoProduct;
import com.mnd.gunreview.service.InfoProductService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/infoProduct")
public class InfoProductController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewPXController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
		
	@Autowired
	private InfoProductService infoProductService;
	
	
	@ApiOperation(value = "모든 상품 리스트를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<InfoProduct>> selectAllProduct() throws Exception {
		logger.debug("selectAllProduct - 호출");
		return new ResponseEntity<List<InfoProduct>>(infoProductService.selectAllProduct(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당 상품의 detail 수정. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{detail}")
	public ResponseEntity<String> updateDetail(String name, String detail) {
		logger.debug("updateDetail - 호출");
		if (infoProductService.updateDetail(name, detail) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "해당 상품의 price 수정. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{price}")
	public ResponseEntity<String> updatePrice(String name, int price) {
		logger.debug("updatePrice - 호출");
		if (infoProductService.updatePrice(name, price) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
