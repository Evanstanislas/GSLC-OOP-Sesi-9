package vehicle;


//Kelas abstrak yang terdiri dari merek, nama, tahun dibuat dan tipe
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

	
	//Setter getter
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
	
	//Metode abstrak
	public abstract void Sound();
	
}
