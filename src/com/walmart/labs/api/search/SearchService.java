package com.walmart.labs.api.search;

import java.util.List;

import com.walmart.labs.api.model.Product;

public interface SearchService {
	public List<Product> getRecommendedProducts(String query);
}
