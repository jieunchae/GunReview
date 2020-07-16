package com.mnd.crawling;

import java.util.StringTokenizer;

import org.apache.tomcat.util.json.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.cj.xdevapi.JsonArray;

public class test {

	public static void main(String[] args) throws Exception {
//		System.out.println(getOpenHour("10060776"));
//		System.out.println(getOpenHour("2047692004"));
		System.out.println(getOpenHour("10809457"));
		
		
	}

	private static String getOpenHour(String shopId) {
		JsonReader jsonReader = new JsonReader();
		StringBuilder URL = new StringBuilder("https://place.map.kakao.com/main/v/");
		URL.append(shopId);
		String getJson = jsonReader.callURL(URL.toString());
		
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(getJson);
	
		System.out.println(object);
		System.out.println(((JsonObject)((JsonObject)object.get("basicInfo"))).has("openHour"));
		if(!((JsonObject)((JsonObject)object.get("basicInfo"))).has("openHour")) return null;
		
		
		com.google.gson.JsonArray openHour = (com.google.gson.JsonArray) ((JsonObject)((JsonObject)object.get("basicInfo")).get("openHour")).get("periodList");
		com.google.gson.JsonArray timeList = (com.google.gson.JsonArray) ((JsonObject) openHour.get(0)).get("timeList");
		com.google.gson.JsonArray offdayList = (com.google.gson.JsonArray) ((JsonObject)((JsonObject)object.get("basicInfo")).get("openHour")).get("offdayList");
		
		System.out.println(offdayList);
		StringBuilder sb = new StringBuilder();
		
		sb.append("<b>영업시간</b><br>");
		for(int i=0;i<timeList.size();i++) {
			JsonObject obj = (JsonObject) timeList.get(i);
			sb.append(obj.get("dayOfWeek").toString().substring(1, obj.get("dayOfWeek").toString().length()-1) + " : ");
			sb.append(obj.get("timeSE").toString().substring(1, obj.get("timeSE").toString().length()-1));
			sb.append("<br>");
		}
		
		if(offdayList != null) {
			sb.append("<b>휴무일</b><br>");
			for(int i=0;i<offdayList.size();i++) {
				JsonObject obj = (JsonObject) offdayList.get(i);
				if(!obj.has("weekAndDay")) {
					sb.append(obj.get("holidayName").toString().substring(1, obj.get("holidayName").toString().length()-1) + "<br>");
				}
				else sb.append(obj.get("weekAndDay").toString().substring(1, obj.get("weekAndDay").toString().length()-1) + "<br>");
			}
		}
		return sb.toString();
	}
	
	
	
/*[
	{"periodName":"영업기간",
	 "timeList": [{"timeName":"영업시간","timeSE":"07:00 ~ 24:00","dayOfWeek":"월~금"},{"timeName":"영업시간","timeSE":"08:00 ~ 24:00","dayOfWeek":"토"},{"timeName":"영업시간","timeSE":"08:00 ~ 22:30","dayOfWeek":"일"}]
	},
	{"periodName":"공휴일","timeList":[{"timeName":"영업시간","timeSE":"08:00 ~ 22:30","dayOfWeek":"매일"}]}]


*/
}
