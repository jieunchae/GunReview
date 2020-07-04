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

import com.mnd.gunreview.dto.ReviewShop;
import com.mnd.gunreview.service.ReviewShopService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/reviewShop")
public class ReviewShopController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewShopController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ReviewShopService reviewShopService;
	
	@ApiOperation(value = "모든 리뷰를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<ReviewShop>> selectReviewShop() throws Exception {
		logger.debug("selectReviewShop - 호출");
		return new ResponseEntity<List<ReviewShop>>(reviewShopService.selectReviewShop(), HttpStatus.OK);
	}

  @ApiOperation(value = "기본키 no에 해당하는 리뷰를 반환한다.", response = ReviewShop.class)    
	@GetMapping("detail/{no}")
	public ResponseEntity<ReviewShop> selectReviewShopByNo(@PathVariable int no) {
		logger.debug("selectReviewShopByNo - 호출");
		return new ResponseEntity<ReviewShop>(reviewShopService.selectReviewShopByNo(no), HttpStatus.OK);
	}
  
  @ApiOperation(value = "page에 해당하는 리뷰 리스트를 반환한다.", response = List.class)    
	@GetMapping("page/{page}")
	public ResponseEntity<List<ReviewShop>> selectReviewShopByPage(@PathVariable int page) {
		logger.debug("selectReviewShopByPage - 호출");
		return new ResponseEntity<List<ReviewShop>>(reviewShopService.selectReviewShopByPage(page), HttpStatus.OK);
	}


  @ApiOperation(value = "새로운 리뷰를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertReviewShop(@RequestBody ReviewShop review) {
		logger.debug("insertReviewShop - 호출");
		if (reviewShopService.insertReviewShop(review) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
  
  @ApiOperation(value = "No에 해당하는 리뷰의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateReviewShop(@RequestBody ReviewShop review) {
		logger.debug("updateReviewShop - 호출");
		logger.debug("" + review);
		
		if (reviewShopService.updateReviewShop(review) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "글번호(no)에 해당하는 리뷰를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteReviewShop(@PathVariable int no) {
		logger.debug("deleteReviewShop - 호출");
		if (reviewShopService.deleteReviewShop(no) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
  
  @ApiOperation(value = "식당 id에 해당하는 모든리뷰를 반환한다.", response = ReviewShop.class)    
	@GetMapping("{id}")
	public ResponseEntity<List<ReviewShop>> selectReviewShopById(@PathVariable String id) {
		logger.debug("selectReviewShopById - 호출");
		return new ResponseEntity<List<ReviewShop>>(reviewShopService.selectReviewShopById(id), HttpStatus.OK);
	}
  
  @ApiOperation(value = "식당 id에 해당하는 모든리뷰를 페이지별로반환한다.", response = ReviewShop.class)    
	@GetMapping("{id}/{page}")
	public ResponseEntity<List<ReviewShop>> selectReviewShopByIdPage(@PathVariable String id,int page) {
		logger.debug("selectReviewShopByIdPage - 호출");
		return new ResponseEntity<List<ReviewShop>>(reviewShopService.selectReviewShopByIdPage(id, page), HttpStatus.OK);
	}
}
