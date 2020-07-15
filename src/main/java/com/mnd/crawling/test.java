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

		JsonReader jsonReader = new JsonReader();
		StringBuilder URL = new StringBuilder("https://place.map.kakao.com/main/v/");
		URL.append("17884744");
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
		
		System.out.println(sb);
		
		
	}
/*[
	{"periodName":"영업기간",
	 "timeList": [{"timeName":"영업시간","timeSE":"07:00 ~ 24:00","dayOfWeek":"월~금"},{"timeName":"영업시간","timeSE":"08:00 ~ 24:00","dayOfWeek":"토"},{"timeName":"영업시간","timeSE":"08:00 ~ 22:30","dayOfWeek":"일"}]
	},
	{"periodName":"공휴일","timeList":[{"timeName":"영업시간","timeSE":"08:00 ~ 22:30","dayOfWeek":"매일"}]}]


*/
}
