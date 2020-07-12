package com.mnd.interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mnd.gunreview.dto.User;
import com.mnd.gunreview.service.UserService;


//인증을 위한 인터셉터
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Resource
	private UserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 컨트롤러가 실행되기 전
		System.out.println("==========FILTER BEGIN=============");
		logger.debug("==========FILTER BEGIN=============");
		//logger.debug("Request URI=====>" + request.getRequestURI());
		
		//헤더로부터 토큰을 읽음
		//String token = request.getHeader(HttpHeaders.AUTHORIZATION);
//		String token =  "hZmg486N40HlXpqPnCzFIIMhpy69aQS0fZ6RBgorDNQAAAFzPsMTig";
		String token =  "vqS6F6z36zmycGkMerwuyTcAIPQHroifzsRLMgopcBMAAAFzQahjeQ";
		//인증과정 수행
		//1. 토큰으로 부터 kakao 서버에서 userId를 가져옴 - 만약 토큰이 유효하지 않다면 응답 x
		String id = getTokenExpired(token);
		System.out.println("id : "+ id);
		User user = null;
		if(id.equals("expired")) {
			//만료응답
		}else if(id.equals("type_error")) {
			//형식에러
		}else {
			//2. 토큰으로 가져온 userId가 DB에 있는지 확인
			try {
				user = userService.selectUserById(id);
				System.out.println(user.toString());
			}catch(NullPointerException e) {
				//3.없으면 insert
				if(user ==null) {
					System.out.println("user null");
					user = getUserInfo(token); //user 정보 받아오기
				
					userService.insertUser(user);
				}
//				user = getUserInfo(token); //user 정보 받아오기
//				System.out.println(user.toString());
//				if(user != null)
//					userService.insertUser(user);
			}
			
			//4. 있다면 user정보 넘겨줌
			//그 결과를 request attribute로 넘겨준다
			request.setAttribute("user",user);
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러 실행 후
		logger.debug("==========FILTER END=============");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	public String getTokenExpired(String access_token) {
		String reqURL = "https://kapi.kakao.com/v1/user/access_token_info";
		String id = "";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			//요청 Header에 token 포함
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			if(responseCode == 401) {	//토큰 만료
				return "expired";
			}else if(responseCode == 400) {	//잘못된 형식
				return "type_error";
			}
			else {	//토큰 만료 x
				//요청을 통해 id얻어옴
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				String result = "";
				
				while((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : " + result);
				
				//Json 파싱
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				id = element.getAsJsonObject().get("id").getAsString();
				
				//확인
				System.out.println("id : " + id);
				
				br.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public User getUserInfo(String access_token) {
		User user = new User();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			//요청 Header에 token 포함
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			//요청을 통해 사용자 정보 얻어옴
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
				
			while((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
				
			//Json 파싱
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().getAsJsonObject("kakao_account").getAsJsonObject();
			
			
			String id = element.getAsJsonObject().get("id").getAsString();
			user.setId(id);
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
			user.setEmail(email);
			
			try {
				String age_range = kakao_account.getAsJsonObject().get("age_range").getAsString();
				user.setAge_range(age_range);
			}catch(NullPointerException e) {
				user.setAge_range("");
			}
			
			try {
				String birthday = kakao_account.getAsJsonObject().get("birthday").getAsString();
				user.setBirthday(birthday);
			}catch(NullPointerException e) {
				user.setBirthday("");
			}
			
			String gender = kakao_account.getAsJsonObject().get("gender").getAsString();
			user.setGender(gender);
			
			//확인
			System.out.println("id : " + id);
			System.out.println("email : " + email);
			//System.out.println("age_range : " + age_range);
			//System.out.println("birthday : " + birthday);
			System.out.println("gender : " + gender);
				
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return user;
	}
}
