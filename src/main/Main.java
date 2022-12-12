package main;
import java.util.ArrayList;
import java.util.Scanner;

import vehicle.*;

public class Main {
	Scanner scan= new Scanner(System.in);
	ArrayList<Vehicle> VehList= new ArrayList<>();
	
	public final void pressEnter() {
		System.out.println("Press Enter to continue...");
		scan.nextLine();
	}
	
	public void NewVehicle() {
		String brand;
		String name;
		String age;
		String type;
		System.out.println("What's the brand?");
		brand= scan.nextLine();
		System.out.println("What's the name?");
		name= scan.nextLine();
		System.out.println("When this is made?");
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
			VehList.add(new Airplane(brand, name, age, type));
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
	
	public void Heating() {
		if (VehList.isEmpty()){
			System.out.println("There's no vehicle");
			return;
		}
		String NameCheck;
		System.out.println("Select a vehicle to be heated up");
		NameCheck= scan.nextLine();
		
		for (Vehicle V : VehList) {
			if(V.getName().equals(NameCheck)) {
				V.Sound();
			}
			else {
				System.out.println("We can't find the vehicle to be heated up");
				break;
			}
		}
	}
	
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
	
	public Main() {
		MainMenu();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
