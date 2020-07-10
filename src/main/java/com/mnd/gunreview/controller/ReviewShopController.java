package com.mnd.gunreview.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiProgressBarUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
  
  @ApiOperation(value = "파일을 입력한다. 그리고 DB입력 성공여부에 따라 파일 경로 또는 'fail' 문자열을 반환한다.")
  @PostMapping("upload")
	public String doFileUpload(@RequestParam("upload_file") MultipartFile uploadfile, HttpServletRequest request) {	
		try {
			//업로드되는 파일 이름 중간에 날짜줄거임
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			Date nowdate = new Date();
			String dateString = formatter.format(nowdate);
			
	  		//웹서비스 경로 지정
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "resources/upload/";
			String filename = dateString+"_"+uploadfile.getOriginalFilename();
			
			//System.out.println(root_path+attach_path+filename);
			
            FileOutputStream fos = new FileOutputStream(root_path+attach_path+filename);
            // 파일 저장할 경로 + 파일명을 파라미터로 넣고 fileOutputStream 객체 생성하고
            InputStream is = uploadfile.getInputStream();
            // file로 부터 inputStream을 가져온다.
	  		
	  		int readCount = 0;
	        byte[] buffer = new byte[2048];
	        // 파일을 읽을 크기 만큼의 buffer를 생성하고
	        // ( 보통 1024, 2048, 4096, 8192 와 같이 배수 형식으로 버퍼의 크기를 잡는 것이 일반적이다.)
	            
	        while ((readCount = is.read(buffer)) != -1) {
	          //  파일에서 가져온 fileInputStream을 설정한 크기 (1024byte) 만큼 읽고    
	          fos.write(buffer, 0, readCount);
	          // 위에서 생성한 fileOutputStream 객체에 출력하기를 반복한다
	        }

			return root_path+attach_path+filename;
			
	    }catch (Exception ex) {
	         throw new RuntimeException("file Save Error");
	    }
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
