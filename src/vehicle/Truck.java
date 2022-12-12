package vehicle;

public class Truck extends Vehicle{

	public Truck(String brand, String name, String age, String type) {
		super(brand, name, age, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Sound() {
		// TODO Auto-generated method stub
		System.out.println("GEGEGEGEGE, your " +this.name + " has been heated up");
	}
	
	
}
