package midproject;

public abstract class vehicle {
	
	String vehicleType; // Car/Motorcycle
	String type; // [SUV/Supercar/Minivan]/[Automatic/Manual]
	String brand; // Min 5 char
	String name; // Min 5 char
	String licenseNumber; // [A 1 A] - [Z 9999 ZZZ] 
	int topSpeed; // 100-250
	int gasCapacity; // 30-60
	int wheel; // [4-6] / [2-3]
	

	public vehicle(String vehicleType, String type, String brand, String name, String licenseNumber, int topSpeed,
			int gasCapacity, int wheel) {
		
		this.vehicleType = vehicleType;
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.topSpeed = topSpeed;
		this.gasCapacity = gasCapacity;
		this.wheel = wheel;
	}
	
	abstract void entSystem();
	
	public String getVehicleType() {
        return vehicleType;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getGasCapacity() {
        return gasCapacity;
    }

    public int getWheel() {
        return wheel;
    }
}
