package com.walmart.labs.api.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.parser.JSONParser;

public class JsonUtil {
	Properties prop = new Properties();
	Map<String, String> fields = new HashMap<String, String>();

	public JsonUtil() {
		InputStream input = null;
		try {
			// input=new FileInputStream("config.properties");
			String propFileName = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (input != null) {
				prop.load(input);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			fields.put("APIKey", prop.getProperty("APIKey"));
		} catch (Exception e) {
			System.out.println("Issue will be initialized" + e);
		}
	}

	public String getJSONResponseString(String address) {
		String result=null;
		StringBuffer res = new StringBuffer();
		try {
			URL url = new URL(address);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
			int responseCode = httpConnection.getResponseCode();
			if (responseCode == HttpsURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				String inputLine;
				while ((inputLine = reader.readLine()) != null) {
					res.append(inputLine.trim());
				}
				reader.close();
			}
			result=res.toString();
			//System.out.println(result);
		} catch (Exception e) {
			System.out.println("Error occured while parsing walmart api" + e.getLocalizedMessage());
		}
		return result;
	}

	public String getSearchUrl(String queryString) {
		fields.put("SearchAPI", prop.getProperty("SearchAPI"));
		StringBuffer buf = new StringBuffer();
		buf.append(fields.get("SearchAPI")).append("?");
		buf.append("apiKey=" + fields.get("APIKey"));
		buf.append("&query=" + queryString);
		//System.out.println("Search URL IS" + buf.toString());
		return buf.toString();
	}

	public String getRecommUrl(long itemId) {
		// http://api.walmartlabs.com/v1/nbp?apiKey={apiKey}&itemId={itemID}
		fields.put("ProRecAPI", prop.getProperty("ProRecAPI"));
		StringBuffer buf = new StringBuffer();
		buf.append(fields.get("ProRecAPI")).append("?");
		buf.append("apiKey=" + fields.get("APIKey"));
		buf.append("&itemId=" + itemId);
		//System.out.println("Recomm Url IS" + buf.toString());
		return buf.toString();
	}

	public String getReviewUrl(long itemId) {
		// http://api.walmartlabs.com/v1/reviews/33093101?apiKey={apiKey}&lsPublisherId={Your
		// LinkShare Publisher Id}&format=json
		fields.put("ReviewsAPI", prop.getProperty("ReviewsAPI"));
		StringBuffer buf = new StringBuffer();
		buf.append(fields.get("ReviewsAPI")).append(itemId).append("?");
		buf.append("apiKey=" + fields.get("APIKey"));
		buf.append("&format=json");
		//System.out.println("ReviewsAPI Url IS" + buf.toString());
		return buf.toString();
	}
}
