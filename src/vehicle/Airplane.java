package vehicle;

import java.util.Random;

import main.AirStuff;

public class Airplane extends Vehicle implements AirStuff{
	public int Enginenum;
	public String Enginetype;
	public String regis= "";
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

	public int getEnginenum() {
		return Enginenum;
	}

	public void setEnginenum(int enginenum) {
		Enginenum = enginenum;
	}

	public String getEnginetype() {
		return Enginetype;
	}

	public void setEnginetype(String enginetype) {
		Enginetype = enginetype;
	}

	public String getRegis() {
		return regis;
	}

	public void setRegis(String regis) {
		this.regis = regis;
	}

	@Override
	//Membuat registrasi seperti yang ada di nomor ekor
	public String CreateRegis() {
		Random r= new Random();
		String regis="PK-"; char temp; //Menggunakan PK- karena kita ada di Indonesia
		for(int a=0;a<3;a++) {
			temp = (char) ('A'+ r.nextInt(26));
			regis+=temp;
		}
		this.regis=regis;
		return regis;
	}

}
