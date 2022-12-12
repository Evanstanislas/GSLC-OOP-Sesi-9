package vehicle;

public class Airplane extends Vehicle{

	public Airplane(String brand, String name, String age, String type) {
		super(brand, name, age, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Sound() {
		System.out.println("NGGGGGGIIIIIINNGGGGG, your " + this.name + " has been heated up");
		
	}
	
}
