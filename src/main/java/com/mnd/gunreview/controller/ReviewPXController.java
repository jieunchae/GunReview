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
import com.mnd.gunreview.service.InfoProductService;
import com.mnd.gunreview.service.ReviewPXService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/gunreview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/reviewPX")
public class ReviewPXController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewPXController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ReviewPXService reviewPXService;
	
	@Autowired
	private InfoProductService infoProductService;
	
	
	@ApiOperation(value = "해당 상품의 모든 리뷰를 반환한다.", response = List.class)
	@GetMapping("all/{review_productname}")
	public ResponseEntity<List<ReviewPX>> selectReviewByProduct(@PathVariable String review_productname) throws Exception {
		logger.debug("selectReviewByProduct - 호출");
		System.out.println(reviewPXService.selectReviewByProduct(review_productname));
		return new ResponseEntity<List<ReviewPX>>(reviewPXService.selectReviewByProduct(review_productname), HttpStatus.OK);
	}
	
//	@ApiOperation(value = "자신의 아이디로 쓴 리뷰 조회(전체 상품에 대해)", response = List.class)
//	@GetMapping("{userid}")
//	public ResponseEntity<List<ReviewPX>> selectAllReviewByUserId(@PathVariable String userid) throws Exception {
//		logger.debug("selectAllReviewByUserId - 호출");
//		return new ResponseEntity<List<ReviewPX>>(reviewPXService.selectAllReviewByUserId(userid), HttpStatus.OK);
//	}
//	
//	@ApiOperation(value = "자신의 아이디로 쓴 리뷰 조회(해당 상품에 대해)", response = List.class)
//	@GetMapping("{userid}/{review_productname}")
//	public ResponseEntity<List<ReviewPX>> selectReviewByUserId(@PathVariable String userid, String review_productname) throws Exception {
//		logger.debug("selectReviewByUserId - 호출");
//		return new ResponseEntity<List<ReviewPX>>(reviewPXService.selectReviewByUserId(userid, review_productname), HttpStatus.OK);
//	}
	
	@ApiOperation(value = "새로운 리뷰를 입력함과 동시에 InfoProduct의 평점 합, 리뷰 수, 이미지를 업데이트한다. "
			+ "그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertReview(@RequestBody ReviewPX review) {
		logger.debug("insertReview - 호출");
		if(reviewPXService.insertReview(review) == 1) {
			infoProductService.updateSumRate(review.getReview_productname());
			infoProductService.updateNum(review.getReview_productname());
			infoProductService.updateImg(review.getReview_productname());
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "No에 해당하는 리뷰의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateReviewShop(@RequestBody ReviewPX review) {
		logger.debug("updateReviewShop - 호출");
		logger.debug("" + review);
		if (reviewPXService.updateReview(review) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "글번호(no)에 해당하는 리뷰를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteReview(@PathVariable int no) {
		logger.debug("deleteReview - 호출");
		if (reviewPXService.deleteReview(no) == 1) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
