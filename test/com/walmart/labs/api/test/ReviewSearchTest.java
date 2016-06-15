package com.walmart.labs.api.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.walmart.labs.api.model.Product;
import com.walmart.labs.api.search.ReviewSearchImpl;
import com.walmart.labs.api.search.SearchService;

public class ReviewSearchTest {
SearchService searchSearvice;

@Before
public void setUp(){
	searchSearvice=new ReviewSearchImpl();
}
	@Test
	public void test() {
		String userQuery="mobile";
		assertNotNull(searchSearvice.getRecommendedProducts(userQuery));
		
		List<Product> p=searchSearvice.getRecommendedProducts(userQuery);
		assertFalse(p.isEmpty());
	}

}
