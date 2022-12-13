package vehicle;

public class Bus extends Vehicle {

	public Bus(String brand, String name, String age, String type) {
		super(brand, name, age, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Sound() {
		System.out.println("HUMMM CESSS, your " + this.brand + " " +this.name + " has been heated up");
		
	}
	
	
}
