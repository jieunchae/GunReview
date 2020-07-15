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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mnd.crawling.JsonReader;
import com.mnd.gunreview.dto.Shop;
import com.mnd.gunreview.service.ShopService;

import io.swagger.annotations.ApiOperation;

//http://localhost:9999/GunReview/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/shop")
public class ShopController {
 
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ShopService shopService;

  @ApiOperation(value = "모든 상업시설의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Shop>> retrieveShop() throws Exception {
		logger.debug("retrieveShop - 호출");
		return new ResponseEntity<List<Shop>>(shopService.selectShop(), HttpStatus.OK);
	}

  @ApiOperation(value = "장소 ID에 해당하는 정보를 반환한다.", response = Shop.class)    
	@GetMapping("{id}")
	public ResponseEntity<Shop> detailShop(@PathVariable String id) {
		logger.debug("detailShop - 호출");
		return new ResponseEntity<Shop>(shopService.selectShopById(id), HttpStatus.OK);
	}
  @ApiOperation(value = "중심 좌표 기준 3km내의 모든 상업시설을 반환한다.", response = Shop.class)    
 	@GetMapping("loc/{lat}/{lng}")
 	public ResponseEntity<List<Shop>> retrieveShopByLoc(@PathVariable double lat,@PathVariable double lng) {
 		logger.debug("retrieveShopByLoc - 호출");
 		return new ResponseEntity<List<Shop>>(shopService.selectShopByLoc(lat,lng), HttpStatus.OK);
 	}
  
  @ApiOperation(value = "새로운 장소 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeShop(@RequestBody Shop shop) {
		logger.debug("writeShop - 호출");
		if (shopService.insertShop(shop) == 1) {
			shopService.updateOpenHour(shop.getId(), getOpenHour(shop.getId()));
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "id에 해당하는 장소의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{id}")
	public ResponseEntity<String> updateShop(@RequestBody Shop shop) {
		logger.debug("updateShop - 호출");
		logger.debug("" + shop);
		
		if (shopService.updateShop(shop) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

  @ApiOperation(value = "id에 해당하는 장소의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteShop(@PathVariable String id) {
		logger.debug("deleteShop - 호출");
		if (shopService.deleteShop(id) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
  
  public String getOpenHour(String shopId) {
	  JsonReader jsonReader = new JsonReader();
		StringBuilder URL = new StringBuilder("https://place.map.kakao.com/main/v/");
		URL.append("1862219579");
		String getJson = jsonReader.callURL(URL.toString());
		
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(getJson);
		com.google.gson.JsonArray openHour = (com.google.gson.JsonArray) ((JsonObject)((JsonObject)object.get("basicInfo")).get("openHour")).get("periodList");
		com.google.gson.JsonArray timeList = (com.google.gson.JsonArray) ((JsonObject) openHour.get(0)).get("timeList");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<timeList.size();i++) {
			JsonObject obj = (JsonObject) timeList.get(i);
			sb.append(obj.get("dayOfWeek").toString().substring(1, obj.get("dayOfWeek").toString().length()-1) + " : ");
			sb.append(obj.get("timeSE").toString().substring(1, obj.get("timeSE").toString().length()-1));
			sb.append("<br>");
		}
		return sb.toString();
  }
}