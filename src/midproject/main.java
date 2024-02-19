package midproject;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	private static ArrayList<vehicle> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		
		while (true){
			int choice = 0;
			
			System.out.println("Menu:\n"
							+ "1. Input\n"
							+ "2. View list to test drive\n"
							+ "3. Exit program\n"
							+ "your choice : ");
			
			try {
				choice=scanner.nextInt();
				scanner.nextLine();
			}
			catch (Exception e){
				System.out.println("Invalid input");
			}
			
			switch(choice) {
				case 1:
					inputVehicle();
				break;
				
				case 2:
					viewVehicle();
				break;
				
				case 3:
					System.out.println("Exit program...");
					System.exit(0);
				break;
				
				default:
					System.out.println("Invalid input");
				break;
			}
			
			System.out.println();
		}
	}
	
	
	static void inputVehicle() {
		
		String typeVehicle;
		String brand;
		String name;
		String license;
		int topSpeed = 0;
		int gasCapacity = 0;
		int wheel = 0;
		String type;
		int entertainment;
		int helm = 0;
		
		do {
			System.out.println("Input type of vehicle [Car | Motorcycle]:");
			typeVehicle = scanner.nextLine();
			
			if(!typeVehicle.matches("(?i)Car|Motorcycle")) {
				System.out.println("Choose between car or motorcycle");
			}
		} while(!typeVehicle.matches("(?i)Car|Motorcycle"));
		
		
		do {
			System.out.println("Input brand [>=5]:");
			brand = scanner.nextLine();
			
			if(brand.length()<5) {
				System.out.println("Name must be at least 5 characters");
			}
		} while(brand.length()<5);
		
		
		do {
			System.out.println("Input name [>=5]:");
			name = scanner.nextLine();
			
			if(name.length()<5) {
				System.out.println("Name must be at least 5 characters");
			}
		} while(name.length()<5);
		
		
		do {
			System.out.println("Input license :");
			license = scanner.nextLine();
			
			if(!isValidlicensePlate(license)) {
				System.out.println("license plate format is invalid");
			}
		} while(!isValidlicensePlate(license));
		
		
		do {
			System.out.println("Input top speed [100 <= topSpeed <= 250]:");
			try {
			topSpeed = scanner.nextInt();
			scanner.nextLine();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
			
			if(topSpeed<100 || topSpeed>250)
			{
				System.out.println("Top speed must be between 100 to 250");
			}
		} while(topSpeed<100 || topSpeed>250);
		
			
		do {
			System.out.println("Input gas capacity [30 <= gasCap <= 60]:");
			try {
			gasCapacity = scanner.nextInt();
			scanner.nextLine();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
			
			if(gasCapacity<30 || gasCapacity>60) {
				System.out.println("Gas capacity must be between 30 to 60");
			}
		} while(gasCapacity<30 || gasCapacity>60);
		
		
			if(typeVehicle.equalsIgnoreCase("Car")) {
				
				do {
					System.out.println("Input wheel [4 <= whell <=6]:");
					try {
						wheel = scanner.nextInt();
						scanner.nextLine();
						}
						catch(Exception e) {
							System.out.println("Invalid Input");
						}
					
					if(wheel<4 || wheel>6) {
						System.out.println("Whell amount must be between 4 to 6");
					}
				} while(wheel<4 || wheel>6);
				
				do {
					System.out.println("Input type [SUV | Supercar | Minivan]:");
					type = scanner.nextLine();
					
					if(!type.matches("(?i)SUV|Minivan|Supercar")) {
						System.out.println("Choose between SUV, Supercar, or Minivan");
					}
					
				} while(!type.matches("(?i)SUV|Minivan|Supercar"));
				
				do {
					System.out.println("Input entertainment system amount :");
					entertainment = scanner.nextInt();
					scanner.nextLine();
					
					if(entertainment<1) {
						System.out.println("entertainment system amount must be at least one");
					}
				} while(entertainment<1);
				
				vehicles.add(new car(typeVehicle, type, brand,
						name, license, topSpeed, gasCapacity, wheel, entertainment));
				System.out.println("New car succesfully added");
			}
			else if (typeVehicle.equalsIgnoreCase("Motorcycle")){
				
				do {
					System.out.println("Input type [Automatic | Manual]:");
					type = scanner.nextLine();
					
					if(!type.matches("(?i)Automatic|Manual")) {
						System.out.println("Choose between Automatic or Manual");
					}
				} while(!type.matches("(?i)Automatic|Manual"));
				
				do {
					System.out.println("Input helm amount :");
					try {
						helm = scanner.nextInt();
						scanner.nextLine();
						}
					catch(Exception e) {
							System.out.println("Invalid Input");
						}
					
					if(helm<1) {
						System.out.println("Helm amount must be at least one");
					}
				} while (helm <1);
				
				vehicles.add(new motorcycle(typeVehicle, type, brand,
						name, license, topSpeed, gasCapacity, wheel, helm));
				System.out.println("New motorcycle succesfully added");
			}
			
		System.out.println("Enter to return");
		scanner.nextLine();
		return;
	}
	
	static void viewVehicle() {
	    
	    
	    System.out.println("List of vehicles");
	    System.out.println("|=====|====================|=============================================|");
	    System.out.println("| No  | Type               | Name                                        |");
	    System.out.println("|=====|====================|=============================================|");

	    if (vehicles.isEmpty()) {
	        System.out.println("No vehicles to display.");
	        return;
	    }
	    
	    int count = 1;
	    for (vehicle vehicle : vehicles) {
	        System.out.printf("| %-3d | %-18s | %-43s |\n", count++, vehicle.getVehicleType(), vehicle.getName());
	        System.out.println("|-----|--------------------|---------------------------------------------|");
	    }
	 
	    int chooseTest=0;
	    do {
	    	System.out.println("Pick a vehicle to test drive[Enter '0' to exit]");
		    try {
				chooseTest = scanner.nextInt();
				scanner.nextLine();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}

	        if (chooseTest >= 1 && chooseTest <= vehicles.size()) {
	            testDrive(vehicles.get(chooseTest - 1));
	        } else if (chooseTest == 0) {
	            System.out.println("Exit to menu.");
	            return;
	        } else {
	            System.out.println("Invalid choice. Please enter a valid No.");
	        }
	    } while (chooseTest < 0 || chooseTest > vehicles.size());
	}
	
	static boolean isValidlicensePlate(String licensePlate){
		
		String pattern = "[A-Z] \\d{1,4} [A-Z]{1,3}";
		return licensePlate.matches(pattern);
	}
	
	static void testDrive(vehicle vehicle) {
	    System.out.println("\nDetails for selected vehicle:");
	    System.out.println("Vehicle Type: " + vehicle.getVehicleType());
	    System.out.println("Type: " + vehicle.getType());
	    System.out.println("Brand: " + vehicle.getBrand());
	    System.out.println("Name: " + vehicle.getName());
	    System.out.println("License Plate: " + vehicle.getLicenseNumber());
	    System.out.println("Top Speed: " + vehicle.getTopSpeed());
	    System.out.println("Gas Capacity: " + vehicle.getGasCapacity());
	    System.out.println("Wheel(s): " + vehicle.getWheel());
	    
	    if (vehicle instanceof car) {
	        car car = (car) vehicle;
	        System.out.println("Entertainment System: " + car.getEntertainment());
	        
	        car.entSystem();
	    } else if (vehicle instanceof motorcycle) {
	        motorcycle motorcycle = (motorcycle) vehicle;
	        System.out.println("Number of Helmets: " + motorcycle.getHelm());
	        
	        motorcycle.entSystem();
	        
	        long helmPrice=0;
	        do {
				System.out.println("Input helm price :");
				try {
					helmPrice = scanner.nextInt();
					scanner.nextLine();
					}
				catch(Exception e) {
						System.out.println("Invalid Input");
					}
				
				if(helmPrice<1) {
					System.out.println("Helm price can not be negative");
				}
			} while (helmPrice <1);
	        
	        motorcycle.setHelmPrice(helmPrice);
	        
	        System.out.println("Helm price: " + motorcycle.getHelmPrice());
	        
	    }
	    
	    System.out.println("Enter to return");
		scanner.nextLine();
		return;
	}

	
}
