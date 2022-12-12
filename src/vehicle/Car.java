package vehicle;

public class Car extends Vehicle{

	public Car(String brand, String name, String age, String type) {
		super(brand, name, age, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Sound() {
		// TODO Auto-generated method stub
		System.out.println("Vroommmm, your " + this.brand + " " + this.name + " has been heated up");
	}
	
	
}
