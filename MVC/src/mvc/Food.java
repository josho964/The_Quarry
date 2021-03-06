package mvc;

/**
 * This class is the parent class of all the separate foods.
 * Contains self explanatory getters and setters.
 *
 */
public class Food {

	private String name;
	private Double price;
	private int value;
	
	public Food(String foodName, Double foodPrice, int foodValue)
	{
		name = foodName;
		price = foodPrice;
		value = foodValue;
	}
	
	public Food(){
		
	}
	
	public int getValue()
	{
		return value;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
	        return true;
	    }
	    if (obj == null || obj.getClass() != this.getClass()) {
	        return false;
	    } 
	    
	    Food other = (Food) obj;
	    return (other.name != null && other.name.equals(name));
	
	}
	
	@Override
	public String toString() {
		return name;
	}
}