package midproject;

public class motorcycle extends vehicle{
	
	int helm; // Min 1
	long helmPrice;
	
	public motorcycle(String vehicleType, String type, String brand,
			String name, String licenseNumber, int topSpeed,
			int gasCapacity, int wheel, int helm) {
			
			super(vehicleType, type, brand, name, licenseNumber,
					topSpeed, gasCapacity, wheel);
			
			this.helm=helm;
		}
	
	@Override
	void entSystem() {
		System.out.println(name+" is standing");
	}
	
	public int getHelm() {
        return helm;
    }
	
	public long getHelmPrice() {
        return helmPrice;
    }
	
	public void setHelmPrice(long helmPrice) {
		this.helmPrice=helmPrice;
	}
}
