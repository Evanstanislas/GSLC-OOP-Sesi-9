package vehicle;

public class Motorcycle extends Vehicle{

	public Motorcycle(String brand, String name, String age, String type) {
		super(brand, name, age, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Sound() {
		// TODO Auto-generated method stub
		System.out.println("BREEM, your " +this.name + " has been heated up");
	}
	
}
