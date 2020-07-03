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

import com.mnd.gunreview.dto.UserLoc;
import com.mnd.gunreview.service.UserLocService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/userloc")
public class UserLocController {

	private static final Logger logger = LoggerFactory.getLogger(UserLocController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserLocService userLocService;
	
	@ApiOperation(value = "모든 회원 관심지역 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<UserLoc>> selectUserLoc() throws Exception {
		logger.debug("selectUserLoc - 호출");
		return new ResponseEntity<List<UserLoc>>(userLocService.selectUserLoc(), HttpStatus.OK);
	}

  @ApiOperation(value = "유저 ID에 해당하는 관심지역 정보 리스트를 반환한다.", response = List.class)    
	@GetMapping("{userid}")
	public ResponseEntity<List<UserLoc>> selectUserLocByUserid(@PathVariable String userid) {
		logger.debug("selectUserLocByUserid - 호출");
		return new ResponseEntity<List<UserLoc>>(userLocService.selectUserLocByUserid(userid), HttpStatus.OK);
	}

  @ApiOperation(value = "새로운 회원 관심지역정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertUserLoc(@RequestBody UserLoc userloc) {
		logger.debug("insertUserLoc - 호출");
		if (userLocService.insertUserLoc(userloc) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "관심지역 no에 해당하는 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateUserLoc(@RequestBody UserLoc userloc) {
		logger.debug("updateUserLoc - 관심지역 정보 수정");
		logger.debug("" + userloc);
		
		if (userLocService.updateUserLoc(userloc) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "no에 해당하는 관심지역 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteUserLoc(@PathVariable int no) {
		logger.debug("deleteUserLoc- 호출");
		if (userLocService.deleteUserLoc(no) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
