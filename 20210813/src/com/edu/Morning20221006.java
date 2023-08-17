package com.edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ApiTest {

	public void apiTestGet() throws Exception {
		URL url = null;
		String readLine = null;
		StringBuilder buffer = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		HttpURLConnection urlConnection = null;

		int connTimeout = 5000;
		int readTimeout = 3000;

		// 각자 상황에 맞는 IP & url 사용
		String apiUrl = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D";

		try {
			url = new URL(apiUrl);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setConnectTimeout(connTimeout);
			urlConnection.setReadTimeout(readTimeout);
			urlConnection.setRequestProperty("Accept", "application/json;");

			buffer = new StringBuilder();
			if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
				while ((readLine = bufferedReader.readLine()) != null) {
					buffer.append(readLine).append("\n");
				}
			} else {
				buffer.append("code : ");
				buffer.append(urlConnection.getResponseCode()).append("\n");
				buffer.append("message : ");
				buffer.append(urlConnection.getResponseMessage()).append("\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("결과 : " + buffer.toString());

		String result = buffer.toString();
		result = result.substring(result.indexOf("[") + 1, result.indexOf("]"));

		List<HashMap<String, String>> list = jsonToMap(result);
		for (HashMap<String, String> map : list) {
			System.out.println("==========================");
			Set<Entry<String, String>> entrySet = map.entrySet();
			System.out.print("{");
			int idx = 0;
			for (Entry<String, String> ent : entrySet) {
				if (idx++ == 0) {
					System.out.printf("%s : %s\n", ent.getKey(), ent.getValue());
				} else {
					System.out.printf(",%s : %s\n", ent.getKey(), ent.getValue());
				}
			}
			System.out.println("}");
		}
	}

	public List<HashMap<String, String>> jsonToMap(String json) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		int fromPos, toPos, startPos;
		startPos = 1;
		String term = "";
		String[] rowAry = null;
		while (true) {
			fromPos = json.indexOf("{", startPos);
			if (fromPos == -1)
				break;

			toPos = json.indexOf("}", fromPos);
			startPos = toPos;

			term = json.substring(fromPos + 1, toPos);
			rowAry = term.split(",");
			HashMap<String, String> map = new HashMap<>();
			for (String row : rowAry) {
				map.put(row.substring(0, row.indexOf(":")), row.substring(row.indexOf(":") + 1));
			}
			list.add(map);
		}

		return list;
	}

	public void apiTestPost() throws Exception {
		URL url = null;
		String readLine = null;
		StringBuilder buffer = null;
		OutputStream outputStream = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		HttpURLConnection urlConnection = null;

		int connTimeout = 5000;
		int readTimeout = 3000;

		String sendData = "보낼 데이터"; // 대다수의 경우 JSON 데이터 사용
		String apiUrl = "http://localhost:8080/api/test"; // 각자 상황에 맞는 IP & url 사용

		try {
			url = new URL(apiUrl);

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setConnectTimeout(connTimeout);
			urlConnection.setReadTimeout(readTimeout);
			urlConnection.setRequestProperty("Content-Type", "application/json;");
			urlConnection.setDoOutput(true);
			urlConnection.setInstanceFollowRedirects(true);

			outputStream = urlConnection.getOutputStream();

			bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			bufferedWriter.write(sendData);
			bufferedWriter.flush();

			buffer = new StringBuilder();
			if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
				while ((readLine = bufferedReader.readLine()) != null) {
					buffer.append(readLine).append("\n");
				}
			} else {
				buffer.append("\"code\" : \"" + urlConnection.getResponseCode() + "\"");
				buffer.append(", \"message\" : \"" + urlConnection.getResponseMessage() + "\"");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("결과 : " + buffer.toString());
	}
}

public class Morning20221006 {

	public static void main(String[] args) {
		ApiTest api = new ApiTest();
		try {
			api.apiTestGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
