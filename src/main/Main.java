package main;
import java.util.ArrayList;
import java.util.Scanner;

import vehicle.*;

public class Main {
	//Membuat scanner dan arraylist terlebih dahulu
	Scanner scan= new Scanner(System.in);
	ArrayList<Vehicle> VehList= new ArrayList<>();
	
	//metode untuk memberi break agar program bisa lebih realistis dan tidak terasa terlalu cepat
	public final void pressEnter() {
		System.out.println("Press Enter to continue...");
		scan.nextLine();
	}
	
	//Fungsi untuk membuat kendaraan baru (Fungsi Menu 1)
	public void NewVehicle() {
		String brand;
		String name;
		String age;
		String type;
		System.out.print("What's the brand? ");
		brand= scan.nextLine();
		System.out.print("What's the name? ");
		name= scan.nextLine();
		System.out.print("When was the vehicle built? ");
		age= scan.nextLine();
		
		do {
			System.out.print("Now, what is the type? [Car | Airplane | Truck | Motorcycle | Bus] ");
			type= scan.nextLine();
		} while(!type.equals("Car")&& !type.equals("Airplane") && !type.equals("Truck") && !type.equals("Motorcycle")&& !type.equals("Bus"));
		
		if(type.equals("Car")) {
			VehList.add(new Car(brand, name, age, type));
			System.out.println("A new car has been added");
		}
		else if(type.equals("Airplane")) {
			//Jika pesawat maka user harus memberikan beberapa variabel lain
			int Enginenum;
			String Enginetype;
			System.out.print("How many engines do you have? ");
			Enginenum= scan.nextInt();
			scan.nextLine();
			
			do {
				System.out.print("What's the engine type? [Turbofan | Turboprop | Turbojet] ");
				Enginetype= scan.nextLine();
			} while(!Enginetype.equals("Turbofan")&&!Enginetype.equals("Turboprop")&&!Enginetype.equals("Turbojet"));
			
			VehList.add(new Airplane(brand, name, age, type, Enginenum, Enginetype));
			System.out.println("An new airplane has been added");
		}
		else if(type.equals("Truck")) {
			VehList.add(new Truck(brand, name, age, type));
			System.out.println("A new truck has been added");
		}
		else if(type.equals("Motorcycle")) {
			VehList.add(new Motorcycle(brand, name, age, type));
			System.out.println("A new motorcycle has been added");
		}
		else if(type.equals("Bus")) {
			VehList.add(new Bus(brand, name, age, type));
			System.out.println("A new bus has been added");
		}
		
	}
	
	//Melihat kendaraan apa saja yang sudah dimiliki (Fungsi Menu 2)
	public void ShowVehicle() {
		//Jika kosong ya print ini
		if (VehList.isEmpty()) {
			System.out.println("You haven't created your vehicle yet man");
			pressEnter();
			return;
		}
		Vehicle index;
		System.out.printf("| %-4s | %-10s | %-14s | %-20s | %-12s | %-12s |\n", "No." , "Type" ,"Brand", "Name", "Year made", "Registration");
		for(int a=0; a<VehList.size(); a++) {
			index= VehList.get(a);
			//Kalo pesawat akan juga diprint registrasinya
			if(index.getType().equals("Airplane")) {
				System.out.printf("| %-4s | %-10s | %-14s | %-20s | %-12s | %-12s |\n", a+1 , index.getType(), index.getBrand(), index.getName(), index.getAge(), ((Airplane) index).getRegis());
			}
			
			//Kalo bukan pesawat maka akan NA
			else {
				System.out.printf("| %-4s | %-10s | %-14s | %-20s | %-12s | %-12s |\n", a+1 , index.getType(), index.getBrand(), index.getName(), index.getAge(), "NA");
			}
		}
		
	}
	
	//Fungsi untuk memanaskan kendaraan (Memanaskan mesin) (MENU 3)
	public void Heating() {
		if (VehList.isEmpty()){
			System.out.println("There's no vehicle");
			return;
		}
		
		String NameCheck;
		System.out.print("Select a vehicle to be heated up [type all to heat all of them] ");
		NameCheck= scan.nextLine();
		
		//Jika isi kata "all" maka semua mesin akan dijalankan
		if(NameCheck.equals("all")) {
			for (Vehicle V : VehList) {
				V.Sound();
			}
		}
		else {
			for (Vehicle V : VehList) {
				if(V.getName().equals(NameCheck)) {
					V.Sound();
				}
			}
		}
	}
	
	//Mengecek apakah ada pesawat di dalam ArrayList
	public boolean Aircheck() {
		for (Vehicle vehicle : VehList) {
			if(vehicle.getType().equals("Airplane")) {
				return false;
			}
		}
		return true;
		
	}
	
	//Menu 5, membuat registrasi pesawat
	public void Regis() {
		String regis = "";
		//Jika tidak ada data atau tidak ada pesawat maka akan return
		if(VehList.isEmpty()|| Aircheck()) {
			System.out.println("Error, you either don't have a vehicle or you don't have an airplane");
			return;
		}
		else {
			
			String Regischeck;
			System.out.print("Pick a plane to be registered... ");
			Regischeck=scan.nextLine();
			for (Vehicle V : VehList) {
				if(V.getName().equals(Regischeck)) {
					regis= ((Airplane) V).CreateRegis();
				}
			}
			if(regis.equals("")) {
				System.out.println("Error, you either mistyped your airplane name or it doesn't exist");
			}
			else {
				System.out.println("Done, " + regis + " is your registration");
				return;
			}
			
		}
	}
	
	//Menu utama
	public void MainMenu() {
		int Menu;
		do {
			System.out.println("Welcome to your garage");
			System.out.println("1. Create a new Vehicle");
			System.out.println("2. Show my vehicle(s)");
			System.out.println("3. Heat your vehicle up");
			System.out.println("4. Make a registration (Airplane only)");
			System.out.println("5. Exit (for now)");
			System.out.print("What do you want to do? ");
			Menu= scan.nextInt();
			scan.nextLine();
			switch (Menu) {
				case 1:
					NewVehicle();
					pressEnter();
					break;
				case 2:
					ShowVehicle();
					pressEnter();
					break;
				case 3:
					Heating();
					pressEnter();
					break;
				case 4:
					Regis();
					pressEnter();
					break;
				case 5:
					System.out.println("GOODBYE, so sadge");
					break;
				default:
					System.out.println("WHY YOU CHOOSE THIS NUMBER?");
					pressEnter();
					break;
			}
		}while(Menu!=5);
	}
	
	//Bagian pertama untuk menjalankan program, semua dimulai dari sini
	public Main() {
		MainMenu();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
