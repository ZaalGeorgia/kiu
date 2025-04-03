package lesson250403.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExample01 {
	
	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		products.add(new Product("table", 10));
		products.add(new Product("drawer", 70));
		products.add(new Product("chair", 30));
		
		Object[] productsArray = products.toArray();
		
		Arrays.sort(productsArray);
		
		System.out.println(Arrays.toString(productsArray));
		
		products.sort(new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPrice() - o2.getPrice();
			}
		});
		
		System.out.println(products);
		
		products.forEach(System.out::println);
		
		Function<Product, Integer> f = products.get(0)::compareTo;
		BiFunction<Product, Product, Integer> f2 = Product::compareProducts;
		
		int result = f.apply(products.get(1));
		
		System.out.println(result);
		
		List<Product> expensive = products.stream().filter(p -> p.getPrice() > 50).toList();
		
		System.out.println(expensive);
	}

}

class Product implements Comparable<Product> {
	private String title;
	private int price;
	
	public Product(String title, int price) {
		this.title = title;
		this.price = price;
	}

	@Override
	public int compareTo(Product o) {
		return this.getPrice() - o.getPrice();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title + " = " + getPrice();
	}

	public int getPrice() {
		return price;
	}
	
	static int compareProducts(Product p1, Product p2) {
		return p1.compareTo(p2);
	}
}
