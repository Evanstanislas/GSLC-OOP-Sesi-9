package main;
import java.util.ArrayList;
import java.util.Scanner;

import vehicle.*;

public class Main {
	//Membuat scanner dan arraylist terlebih dahulu
	Scanner scan= new Scanner(System.in);
	ArrayList<Vehicle> VehList= new ArrayList<>();
	
	//metode untuk memberi break agar program bisa lebih realistis dan tidak menjadi terasa terlalu cepat
	public final void pressEnter() {
		System.out.println("Press Enter to continue...");
		scan.nextLine();
	}
	
	//Fungsi untuk membuat kendaraan baru
	public void NewVehicle() {
		String brand;
		String name;
		String age;
		String type;
		System.out.println("What's the brand?");
		brand= scan.nextLine();
		System.out.println("What's the name?");
		name= scan.nextLine();
		System.out.println("When was the vehicle built?");
		age= scan.nextLine();
		
		do {
			System.out.println("Now, what is the type? [Car | Airplane | Truck | Motorcycle]");
			type= scan.nextLine();
		} while(!type.equals("Car")&& !type.equals("Airplane") && !type.equals("Truck") && !type.equals("Motorcycle"));
		
		if(type.equals("Car")) {
			VehList.add(new Car(brand, name, age, type));
			System.out.println("A new car has been added");
		}
		else if(type.equals("Airplane")) {
			int Enginenum;
			String Enginetype;
			System.out.println("How many engines do you have?");
			Enginenum= scan.nextInt();
			scan.nextLine();
			
			do {
				System.out.println("What's the engine type? [Turbofan | Turboprop | Turbojet]");
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
		
	}
	
	//Melihat kendaraan apa saja yang sudah dimiliki
	public void ShowVehicle() {
		if (VehList.isEmpty()) {
			System.out.println("You haven't created your vehicle yet man");
			pressEnter();
			return;
		}
		Vehicle index;
		System.out.printf("| %-4s | %-10s | %-14s | %-20s | %-12s |\n", "No." , "Type" ,"Brand", "Name", "Year made");
		for(int a=0; a<VehList.size(); a++) {
			index= VehList.get(a);
			System.out.printf("| %-4s | %-10s | %-14s | %-20s | %-12s |\n", a+1 , index.getType(), index.getBrand(), index.getName(), index.getAge());
		}
		
	}
	
	//Fungsi untuk memanaskan kendaraan (Memanaskan mesin)
	public void Heating() {
		if (VehList.isEmpty()){
			System.out.println("There's no vehicle");
			return;
		}
		
		String NameCheck;
		System.out.println("Select a vehicle to be heated up [type all to heat all of them]");
		NameCheck= scan.nextLine();
		
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
	
	//Menu utama
	public void MainMenu() {
		int Menu;
		do {
			System.out.println("Welcome to your garage");
			System.out.println("What do you to do");
			System.out.println("1. Create a new Vehicle");
			System.out.println("2. Show my vehicle(s)");
			System.out.println("3. Heat your vehicle up");
			System.out.println("4. Exit (for now)");
			
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
					System.out.println("GOODBYE, so sadge");
					break;
				default:
					System.out.println("WHY YOU CHOOSE THIS NUMBER?");
					pressEnter();
					break;
			}
		}while(Menu!=4);
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
