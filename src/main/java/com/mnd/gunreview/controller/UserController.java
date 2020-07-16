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

import com.mnd.gunreview.dto.User;
import com.mnd.gunreview.service.UserService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserService userService;
	
	 @ApiOperation(value = "모든 회원 정보를 반환한다.", response = List.class)
		@GetMapping
		public ResponseEntity<List<User>> selectUser() throws Exception {
			logger.debug("retrieveUser - 호출");
			return new ResponseEntity<List<User>>(userService.selectUser(), HttpStatus.OK);
		}

	  @ApiOperation(value = "유저 ID에 해당하는 회원 정보를 반환한다.", response = User.class)    
		@GetMapping("{id}")
		public ResponseEntity<User> selectUserByUserid(@PathVariable String id) {
			logger.debug("detailShop - 호출");
			return new ResponseEntity<User>(userService.selectUserById(id), HttpStatus.OK);
		}

	  @ApiOperation(value = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
		@PostMapping
		public ResponseEntity<String> insertUser(@RequestBody User user) {
			logger.debug("writeShop - 호출");
			if (userService.insertUser(user) == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}

	  @ApiOperation(value = "유저 id에 해당하는 회원 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
		@PutMapping("{userid}")
		public ResponseEntity<String> updateUser(@RequestBody User user) {
			logger.debug("updateUser - 회원 수정");
			logger.debug("" + user);
			
			if (userService.updateUser(user) == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}

	  @ApiOperation(value = "유저 id에 해당하는 회원 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteBoard(@PathVariable String id) {
			logger.debug("deleteUser- 호출");
			if (userService.deleteUser(id) == 1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	  
	  @ApiOperation(value = "유저 id에 해당하는 리뷰 개수를 반환한다.", response = List.class)
	  	@GetMapping("review/{id}")
		public ResponseEntity<Integer> selectReviewsById(@PathVariable String id) throws Exception {
			logger.debug("selectReviewsById- 호출");
			return new ResponseEntity<Integer>(userService.selectReviewsById(id), HttpStatus.OK);
		}
	  
	  @ApiOperation(value = "유저 id에 해당하는 리뷰 점수 합계를 반환한다.", response = List.class)
	  	@GetMapping("sum/{id}")
		public ResponseEntity<Integer> selectSumReviewsById(@PathVariable String id) throws Exception {
			logger.debug("selectSumReviewsgById- 호출");
			return new ResponseEntity<Integer>(userService.selectSumReviewsById(id), HttpStatus.OK);
		}
	  @ApiOperation(value = "유저 id에 해당하는 크레딧 점수를 반환한다.", response = List.class)
	  	@GetMapping("credit/{id}")
		public ResponseEntity<Integer> selectCreditById(@PathVariable String id) throws Exception {
			logger.debug("selectCreditById- 호출");
			return new ResponseEntity<Integer>(userService.selectCreditById(id), HttpStatus.OK);
		}
}
