package vehicle;

public abstract class Vehicle {
	String brand;
	String name;
	String age;
	String type;
	
	

	public Vehicle(String brand, String name, String age, String type) {
		super();
		this.brand = brand;
		this.name = name;
		this.age = age;
		this.type= type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public abstract void Sound();
	
}
