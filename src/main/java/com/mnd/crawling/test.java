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
//		String URL = "https://place.map.kakao.com/main/v/1862219579?_=1593855867282";
//		Document doc = Jsoup.connect(URL).get();
//		Elements elem = doc.select("meta");
//		String[] str = elem.text().split(" ");
//		Elements elem2=doc.select(".tbl_weather tbody>tr:nth-child(1) img");
		
//		System.out.println("doc : " + doc);
//		System.out.println("doc2 : " + doc.childNodeSize());
//		System.out.println("elem : " + elem.html());
//		System.out.print("str : ");
//		for(String a : str) System.out.print(a + "   ");
		JsonReader jsonReader = new JsonReader();
		StringBuilder URL = new StringBuilder("https://place.map.kakao.com/main/v/1862219579?_=");
		URL.append("1593855867282");
		String getJson = jsonReader.callURL(URL.toString());
//		System.out.println(getJson);
		
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(getJson);
		com.google.gson.JsonArray openHour = (com.google.gson.JsonArray) ((JsonObject)((JsonObject)object.get("basicInfo")).get("openHour")).get("periodList");
		com.google.gson.JsonArray timeList = (com.google.gson.JsonArray) ((JsonObject) openHour.get(0)).get("timeList");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<timeList.size();i++) {
			JsonObject obj = (JsonObject) timeList.get(i);
			sb.append(obj.get("dayOfWeek") + ":");
			sb.append(obj.get("timeSE"));
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
