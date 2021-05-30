package cabInvoiceGenerator;

public class CabService {
	
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int MINIMUM_FARE = 20;
	
	public double computeFare(double distance, int time) {
		double totalfare = 0;
		if(distance == 0.0 && time == 0) {
			return totalfare = 0;			
		}
		if(distance <= 1.0 && time <= 5 ) {
			return totalfare = MINIMUM_FARE;
		}
		totalfare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_TIME);
		return totalfare;
	}
	
	public double computeFareForMultipleRide(double totalFare, final int rides) {
		double totalFareForMultipleRides = totalFare * rides;
		return totalFareForMultipleRides;
	}
}
