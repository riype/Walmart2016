package com.walmart.labs.api.search;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.walmart.labs.api.model.Product;
import com.walmart.labs.api.util.JsonUtil;

public class ReviewSearchImpl implements SearchService{
	static JsonUtil jsonUtil=new JsonUtil();
	/*
	 * getRecommendedProducts is a processor which will take customer query and process the internal walmart
	 * API calls and perform these task.
	 * 1.Searching for products based upon a user-provided search string
	 * 2.Take the first item in the search response as input for a product recommendation search
	 * 3.Retrieve reviews of the first 10 product recommendations
	 * 4.Rank order the recommended products based upon the review sentiments
	 * @param String queryString
	 * */
	public List<Product> getRecommendedProducts(String query) {
		List<Product> listProducts=new ArrayList<Product>();
		long itemId=getUserProductItemId(query);
		if(itemId != 0 ){
		listProducts=getAllBestSellerProduct(itemId);	
		}
		return listProducts;
	}
	private List<Product> getAllBestSellerProduct(long itemCode) {
		List<Product> listProducts = new ArrayList<Product>();
		JSONArray recommJsonArray;
		try {
			String s=jsonUtil.getJSONResponseString(jsonUtil.getRecommUrl(itemCode));
			recommJsonArray = (JSONArray) new JSONParser().parse(s);
//			System.out.println(recommJsonArray);
			//here we are getting 5 items from feed.So we will make our customize Package Object and pass it to there.
			for(int i =0;i<recommJsonArray.size();i++){
				JSONObject explrEachItemObject = (JSONObject) recommJsonArray.get(i);
				Long itemId=(Long) explrEachItemObject.get("itemId");
				if(itemId != null){
				Product temPro=new Product();
				temPro.setBrandName((String)explrEachItemObject.get("brandName"));
				temPro.setName((String)explrEachItemObject.get("name"));
				temPro.setItemId(itemId);
				temPro.setMsrp((Double) explrEachItemObject.get("msrp"));
				temPro.setSalePrice((Double) explrEachItemObject.get("salePrice"));
				temPro.setUpc((String) explrEachItemObject.get("upc"));
				temPro.setThumbnailImage((String) explrEachItemObject.get("thumbnailImage"));
				temPro.setMediumImage((String) explrEachItemObject.get("mediumImage"));
				temPro.setLargeImage((String) explrEachItemObject.get("largeImage"));
				temPro.setItemRating(getItemRating(itemId));
				temPro.setCustomerRatingImage((String) explrEachItemObject.get("customerRatingImage"));
				temPro.setShortDescription((String) explrEachItemObject.get("shortDescription"));
				listProducts.add(temPro);
				}
			}
			}catch(Exception e){
				System.out.println("An exception occured.Please check here "+e);	
			}
		return listProducts;
	}
	private Double getItemRating(Long itemId){
		Double itemRating=0d;
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonReviewObject;
		try {
			jsonReviewObject = (JSONObject) jsonParser.parse(jsonUtil.getJSONResponseString(jsonUtil.getReviewUrl(itemId)));
			JSONObject jsonReviewStastObject=(JSONObject)jsonReviewObject.get("reviewStatistics");
			itemRating=Double.parseDouble((String) jsonReviewStastObject.get("averageOverallRating"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return itemRating;
	}
	/*
	 * getUserProductItemId is a utility method which will take query and return possible item id
	 * Steps that are performed
	 * 1.Searching for products based upon a user-provided search string
	 * 2.Take the first item in the search response as input for a product recommendation search
	 * @param String query
	 * */
	private long getUserProductItemId(String query){
		long itemId=0;
		JSONObject jsonProductSearchObject;
		try {
		JSONParser jsonParser = new JSONParser();
		jsonProductSearchObject=(JSONObject) jsonParser.parse(jsonUtil.getJSONResponseString(jsonUtil.getSearchUrl(query)));
		JSONArray items=(JSONArray) jsonProductSearchObject.get("items");
		JSONObject objectInArray = (JSONObject) items.get(0);
		itemId=(Long) objectInArray.get("itemId");
		}catch(Exception e){
			System.out.println("Exception has occured. Please check here "+e);	
		}
		return itemId;
	}
}
