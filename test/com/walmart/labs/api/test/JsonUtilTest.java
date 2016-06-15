package com.walmart.labs.api.test;

import org.junit.Before;
import org.junit.Test;

import com.walmart.labs.api.util.JsonUtil;

import junit.framework.TestCase;

public class JsonUtilTest extends TestCase {

	private JsonUtil testJsonUtil;
	private String apiKey, searchAPI, proRecAPI, reviewsAPI;
	private String query;

	@Before
	public void setUp() {
		apiKey = "655vytpcvmvyb7yquj7mepxg";
		searchAPI = "http://api.walmartlabs.com/v1/search";
		proRecAPI = "http://api.walmartlabs.com/v1/nbp";
		reviewsAPI = "http://api.walmartlabs.com/v1/reviews/";
		testJsonUtil = new JsonUtil();
	}

	@Test
	public void testSearchUrl() {
		query = "mobile";
		assertEquals(getSearchUrl(query), testJsonUtil.getSearchUrl(query));
	}

	private String getSearchUrl(String query) {
		StringBuilder testSearchUrl = new StringBuilder();
		testSearchUrl.append(searchAPI).append("?apiKey=").append(apiKey).append("&query=").append(query);
		return testSearchUrl.toString();
	}

	@Test
	public void testProRecUrl() {
		Long itemId = 123456l;
		assertEquals(getProRecUrl(itemId), testJsonUtil.getRecommUrl(itemId));
	}

	private String getProRecUrl(long itemId) {
		StringBuilder testProRecUrl = new StringBuilder();
		testProRecUrl.append(proRecAPI).append("?apiKey=").append(apiKey).append("&itemId=").append(itemId);
		return testProRecUrl.toString();
	}

	@Test
	public void testReviewUrl() {
		Long itemId = 123456l;
		assertEquals(getReviewUrl(itemId), testJsonUtil.getReviewUrl(itemId));
	}

	private String getReviewUrl(long itemId) {
		StringBuilder testReviewUrl = new StringBuilder();
		testReviewUrl.append(reviewsAPI).append(itemId).append("?apiKey=").append(apiKey).append("&format=json");
		return testReviewUrl.toString();
	}

	@Test
	public void testNotNullJSONResponseString() {
		String serachObj = "mobile";
		assertNotNull(testJsonUtil.getJSONResponseString(getSearchUrl(serachObj)));
	}
}
