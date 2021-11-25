package Objects;  

import java.util.ArrayList;
import java.util.List;

import Iterator.IteratorClass;

public class CartClass {
	private String identifier;
	private int max;
	private int fill;
	private int totalPrice;
	private List<String> products;

	public CartClass(String identifier, int max) {
		this.identifier=identifier;
		this.max=max;
		fill=0;
		totalPrice=0;
		products = new ArrayList<String>();

	}

	public void addProduct(String name) {
		products.add(new String(name));
		
	}

	public void delProduct(String p) {
		products.remove(indexOfProductsOnCart(p));
	
	}
	
	
	public void addPrice(int value) {
		totalPrice += value;
		
	}
	
	public void delPrice(int value) {
		totalPrice -= value;
		
	}

	public void payCart() {
		totalPrice=0;
		products = new ArrayList<String>();
	}
	
	public void fillIn(int volume) {
		fill+= volume;
		
	}
	
	public void fillOut(int volume) {
		fill-= volume;
		
	}

	public int indexOfProductsOnCart(String p) {
		int result =-1;
		for(int i = 0; i<size();i++) {
			if(products.get(i).equals(p)) {
				result = i;
				break;
			}
		}
		return result;
	}

	public String getIdentifier() {
		return identifier;

	}

	public int getMax() {
		return max;

	}
	
	public int getFill() {
		return fill;
		
	}

	public int getTotalPrice() {
		return totalPrice;

	}
	
	public int size() {
		return products.size();
		
	}
	
	public int getPos(String p) {
		return indexOfProductsOnCart(p);
		
	}
	
	public IteratorClass<String> ListCart() {
		return new IteratorClass<String>(products, products.size());
		
	}

}
