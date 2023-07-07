package com.yedam.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class URLExe {
	public static void main(String[] args) {
		String path = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D";
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.defaultCharset()));

			String str = "";
//			while ((str = br.readLine()) != null) {
//				System.out.println(str);
//			}
			str = br.readLine();
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(str);
			JSONArray jsonAry = (JSONArray) jsonObj.get("data");
			for (int i = 0; i < jsonAry.size(); i++) {
				JSONObject obj = (JSONObject) jsonAry.get(i);
				Set<String> set = obj.keySet();
				System.out.println("-------------------");
				for (String key : set) {
					System.out.println(key + " : " + obj.get(key));
				}
			}
			System.out.println("end of loop");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
