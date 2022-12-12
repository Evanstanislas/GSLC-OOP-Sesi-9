package vehicle;

public class Airplane extends Vehicle{
	public int Enginenum;
	public String Enginetype;
	public Airplane(String brand, String name, String age, String type, int Enginenum, String Enginetype) {
		super(brand, name, age, type);
		this.Enginenum= Enginenum;
		this.Enginetype= Enginetype;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Sound() {
		for (int i = 1; i <= Enginenum; i++) {
			if(Enginetype.equals("Turbofan")) {
				System.out.println("NGGGGGGIIIIIINNGGGGG, your " + this.brand + " " + this.name + "'s Engine number " + i + " has been heated up");
			}
			else if(Enginetype.equals("Turboprop")) {
				System.out.println("BURP BURP BURP, your " + this.brand + " " + this.name + "'s Engine number " + i + " has been heated up");
			}
			else {
				System.out.println("NGGGGGINNGGGG CUSSSSS, , your " + this.brand + " " + this.name + "'s Engine number " + i + " has been heated up");
			}
		}
	}
	
}
