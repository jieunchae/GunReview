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

import com.mnd.gunreview.dto.ReviewPX;
import com.mnd.gunreview.dto.ReviewWelfare;
import com.mnd.gunreview.service.ReviewWelfareService;
import com.mnd.gunreview.service.WelfareService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/reviewWelfare")
public class ReviewWelfareController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewWelfareController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ReviewWelfareService reviewWelfareService;
	@Autowired
	private WelfareService welfareService;
	
	@ApiOperation(value = "모든 리뷰를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<ReviewWelfare>> selectReviewWelfare() throws Exception {
		logger.debug("selectReviewWelfare - 호출");
		return new ResponseEntity<List<ReviewWelfare>>(reviewWelfareService.selectReviewWelfare(), HttpStatus.OK);
	}

  @ApiOperation(value = "기본키 no에 해당하는 리뷰를 반환한다.", response = ReviewWelfare.class)    
	@GetMapping("detail/{no}")
	public ResponseEntity<ReviewWelfare> selectReviewWelfareByNo(@PathVariable int no) {
		logger.debug("selectReviewWelfareByNo - 호출");
		return new ResponseEntity<ReviewWelfare>(reviewWelfareService.selectReviewWelfareByNo(no), HttpStatus.OK);
	}

  @ApiOperation(value = "새로운 리뷰를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertReviewWelfare(@RequestBody ReviewWelfare review) {
		logger.debug("insertReviewWelfare - 호출");
		if (reviewWelfareService.insertReviewWelfare(review) == 1) {
			welfareService.updateWelfareRate(review.getWelfare_id());
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "No에 해당하는 리뷰의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateReviewWelfare(@RequestBody ReviewWelfare review) {
		logger.debug("updateReviewWelfare - 호출");
		logger.debug("" + review);
		
		if (reviewWelfareService.updateReviewWelfare(review) == 1) {
			welfareService.updateWelfareRate(review.getWelfare_id());
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "글번호(no)에 해당하는 리뷰를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteReviewWelfare(@PathVariable int no) {
		logger.debug("deleteReviewWelfare - 호출");
		String welfare_id = reviewWelfareService.selectReviewWelfareByNo(no).getWelfare_id();
		if (reviewWelfareService.deleteReviewWelfare(no) == 1) {
			welfareService.updateWelfareRate(welfare_id);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
  
  @ApiOperation(value = "복지시설 id에 해당하는 모든리뷰를 반환한다.", response = ReviewWelfare.class)    
	@GetMapping("{id}")
	public ResponseEntity<List<ReviewWelfare>> selectReviewShopById(@PathVariable String id) {
		logger.debug("selectReviewShopById - 호출");
		return new ResponseEntity<List<ReviewWelfare>>(reviewWelfareService.selectReviewWelfareById(id), HttpStatus.OK);
	}
  	
  @ApiOperation(value = "자신의 아이디로 쓴 리뷰 조회(전체 상품에 대해)", response = List.class)
	@GetMapping("myreview/{userid}")
	public ResponseEntity<List<ReviewWelfare>> selectAllReviewByUserId(@PathVariable String userid) throws Exception {
		logger.debug("selectAllReviewByUserId - 호출");
		return new ResponseEntity<List<ReviewWelfare>>(reviewWelfareService.selectAllReviewByUserId(userid), HttpStatus.OK);
	}
}
