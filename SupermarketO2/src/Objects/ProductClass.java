package Objects;


public class ProductClass {
	private String name;
	private int volume;
	private int price;

	public ProductClass(String name, int volume, int price) {
		this.name=name;
		this.volume=volume;
		this.price=price;

	}
	
	public String getName() {
		return name;
		
	}
	
	public int getVolume() {
		return volume;
		
	}
	
	public int getPrice() {
		return price;
		
	}
	
	public String toString() {
		return getName()+" "+getPrice();
		
	}	
}
