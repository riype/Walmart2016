import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.walmart.labs.api.model.Product;
import com.walmart.labs.api.search.ReviewSearchImpl;
import com.walmart.labs.api.search.SearchService;

public class Test {
	
	public static void main(String args[]){
		List<Product> listAllProduct=new ArrayList<Product>();
		SearchService searchService=new ReviewSearchImpl();
		listAllProduct=searchService.getRecommendedProducts("mobile");
		Collections.sort(listAllProduct);
		for(Product p:listAllProduct){
			System.out.println("==>"+p.getItemRating());
		}
	}

}
