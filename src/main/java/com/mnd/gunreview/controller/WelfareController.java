package com.mnd.gunreview.controller;

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

import com.mnd.gunreview.dto.Welfare;
import com.mnd.gunreview.service.WelfareService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/welfare")
public class WelfareController {

	private static final Logger logger = LoggerFactory.getLogger(WelfareController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private WelfareService welfareSerivce;

  @ApiOperation(value = "모든 복지시설의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Welfare>> retrieveWelfare() throws Exception {
		logger.debug("retrieveBoard - 호출");
		return new ResponseEntity<List<Welfare>>(welfareSerivce.selectWelfare(), HttpStatus.OK);
	}

  @ApiOperation(value = "ID에 해당하는 정보를 반환한다.", response = Welfare.class)    
	@GetMapping("{id}")
	public ResponseEntity<Welfare> detailWelfare(@PathVariable String id) {
		logger.debug("detailWelfare - 호출");
		return new ResponseEntity<Welfare>(welfareSerivce.selectWelfareById(id), HttpStatus.OK);
	}

  @ApiOperation(value = "새로운 장소 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeWelfare(@RequestBody Welfare welfare) {
		logger.debug("writeWelfare - 호출");
		if (welfareSerivce.insertWelfare(welfare) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "ID에 해당하는 장소의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> updateWelfare(@RequestBody Welfare welfare) {
		logger.debug("updateWelfare- 호출");
		logger.debug("" + welfare);
		
		if (welfareSerivce.updateWelfare(welfare) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "id에 해당하는 장소의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWelfare(@PathVariable String id) {
		logger.debug("deleteWelfare - 호출");
		if (welfareSerivce.deleteWelfare(id) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}