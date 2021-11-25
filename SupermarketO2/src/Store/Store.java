package Store;
 
import Iterator.IteratorClass;
import Objects.CartClass;
import Objects.ProductClass;

public class Store {
	private static final int DEFAULT = 50;
	private int countProducts;
	private int countCarts;
	ProductClass[]products;
	CartClass[]carts;

	public Store() {
		products = new ProductClass[DEFAULT];
		carts = new CartClass[DEFAULT];
		countProducts=0;
		countCarts=0;

	}

	public void createCart(String identifier, int max) {
		carts[countCarts++] = new CartClass(identifier, max);

	}

	public void createProduct(String name, int volume, int price) {
		products[countProducts++] = new ProductClass(name, volume, price);

	}
	
	public void addProduct(String p, CartClass c) {
		
		c.addProduct(p);
		ProductClass o = Pass(p);
		int value = o.getPrice();
		int volume = o.getVolume();
		c.addPrice(value);
		c.fillIn(volume);;
		
	}
	
	public void delProduct(String p, CartClass c) {
		c.delProduct(p);
		ProductClass o = Pass(p);
		int value = o.getPrice();
		int volume = o.getVolume();
		c.delPrice(value);
		c.fillOut(volume);;
	}

	public int getTotlaPrice(CartClass c) {
		return c.getTotalPrice();
		
	}
	
	public boolean ProductIsNotInCart(CartClass c, String p) {
		return c.indexOfProductsOnCart(p)<0;
		
	}
	
	public boolean isFull(CartClass c, ProductClass p) {
		int max = c.getMax();
		int volume = p.getVolume();
		int fill = c.getFill();
		boolean result = false;
		if((fill + volume)>max) {
			result = true;
		}
		return result;
	}
	
	public boolean isEmpty(CartClass c) {
		boolean result = false;
		int x = c.size();
		if(x == 0) {
			result = true;
			
		}
		return result;
	}
	
	public void PayCart(CartClass c) {
		c.payCart();

	}

	public int indexOfCarts(CartClass c) {
		int result=-1;
		for(int i = 0; i<countCarts; i++) {
			if(carts[i] == c) {
				result=i;

			}
		}
		return result;

	}
	
	public int indexOfProducts(ProductClass p) {
		int result=-1;
		for(int i = 0; i<countProducts; i++) {
			if(products[i] == p) {
				result=i;

			}
		}
		return result;

	}
	
	public int howManyCarts() {
		return countCarts;
		
	}
	
	public int howManyProducts() {
		return countProducts;
		
	}
	
	public String toString(ProductClass p) {
		return p.toString();
		
	}
	
	public ProductClass Pass(String product) {
		ProductClass p = null;
		for(int i = 0; i<countProducts; i++) {
			if(products[i].getName().equals(product)) {
				
				p = products[i];
			}
			
		}
		return p;
	}
	
	public CartClass Pass1(String cart) {
		CartClass p = null;
		for(int i = 0; i<countCarts; i++) {
			if(carts[i].getIdentifier().equals(cart)) {
				
				p = carts[i];
			}
			
		}
		return p;
	}
	
	public String olho(String product) {
		ProductClass p = null;
		for(int i = 0; i<countProducts; i++) {
			if(products[i].getName().equals(product)) {
				
				p = products[i];
			}
			
		}
		return p.toString();
	}
	
	public int getPos(CartClass c, String p) {
		return c.getPos(p);
		
	}
	
	public IteratorClass<String> ListCart(CartClass c) {
		return c.ListCart();
		
	}
}
