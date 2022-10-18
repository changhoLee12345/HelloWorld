package com.edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Morning20221006 {
	public void apiTestGet() throws Exception {
		URL url = null;
		String readLine = null;
		StringBuilder buffer = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		HttpURLConnection urlConnection = null;

		int connTimeout = 5000;
		int readTimeout = 3000;

		String apiUrl = "http://localhost:8080/api/test"; // 각자 상황에 맞는 IP & url 사용

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
