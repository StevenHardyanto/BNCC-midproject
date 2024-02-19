package midproject;

public class car extends vehicle{
	
	int entertainment; // Min 1
	
	public car(String vehicleType, String type, String brand,
		String name, String licenseNumber, int topSpeed,
		int gasCapacity, int wheel, int entertainment) {
		
		super(vehicleType, type, brand, name, licenseNumber,
				topSpeed, gasCapacity, wheel);
		
		this.entertainment=entertainment;
	}
	
	@Override
	void entSystem() {
		System.out.println("Turning on entertainment system...");
		if(type.equalsIgnoreCase("Supercar"))
		{
			System.out.println("Boosting");
		}
	}
	
	 public int getEntertainment() {
	        return entertainment;
	    }
}
