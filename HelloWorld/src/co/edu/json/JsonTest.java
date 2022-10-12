package co.edu.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

class Center {
	String id;
	String zipCode;
	String address;
	String sigungu;
	String lng;
	String org;
	String centerType;
	String createdAt;
	String phoneNumber;
	String sido;
	String facilityName;

	@Override
	public String toString() {
		return "Center [id=" + id + ", zipCode=" + zipCode + ", address=" + address + ", sigungu=" + sigungu + ", lng="
				+ lng + ", org=" + org + ", centerType=" + centerType + ", createdAt=" + createdAt + ", phoneNumber="
				+ phoneNumber + ", sido=" + sido + ", facilityName=" + facilityName + "]";
	}

}

public class JsonTest {
	public static void main(String[] args) throws IOException {
		String url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=qCwQYxNXeK%2FaB1Ngf9oNZDttjmjQ6ku1OdR6%2Fd0Jj5EIdqOxMXolplih%2BYjTqB4uxCuK636co3tf9T5%2Fr9OLvw%3D%3D%20";
		InputStream is = new URL(url).openStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		String text = read(br);
		JSONObject obj = new JSONObject(text);
		String result = obj.toString();
		String jsonAryTxt = result.substring(result.indexOf("data") + 6, result.indexOf("currentCount") - 2);
//		System.out.println(jsonAryTxt);

		Gson gson = new GsonBuilder().create();
		Type listType = new TypeToken<ArrayList<Center>>() {
		}.getType();
		List<Center> centers = gson.fromJson(jsonAryTxt, listType);

		for (Center center : centers) {
			System.out.println(center);
		}

	}

	public static String read(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		int temp;

		do {
			temp = reader.read();
			sb.append((char) temp);
		} while (temp != -1);

		return sb.toString();
	}
}
