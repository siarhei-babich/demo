package selenium.webdriver.belavia.dto;

public class Offer {
	
	private String departure;
	private String destination;
	private int price;
	
	public Offer(String departure, String destination, int price) {
		super();
		this.departure = departure;
		this.destination = destination;
		this.price = price;
	}
	
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Offer [departure=" + departure + ", destination=" + destination + ", price=" + price + "]";
	}

}
