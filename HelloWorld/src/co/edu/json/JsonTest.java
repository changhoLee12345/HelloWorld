package co.edu.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JsonTest {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("");
			InputStream is = url.openStream();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
