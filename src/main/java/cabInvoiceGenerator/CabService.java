package cabInvoiceGenerator;

public class CabService {
	
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int MINIMUM_FARE = 20;
	
	double totalfare;
	double totalFareForMultipleRides;
	double averageFarePerRide;
	
	public double computeFare(double distance, int time) {
		totalfare = 0;
		if(distance == 0.0 && time == 0) {
			return totalfare = 0;			
		}
		if(distance <= 1.0 && time <= 5 ) {
			return totalfare = MINIMUM_FARE;
		}
		totalfare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_TIME);
		return totalfare;
	}

	public double computeFare(Ride[] rides) {
		for(Ride ride:rides) {
			totalfare += this.computeFare(ride.distance, ride.time);
		}
		return totalfare;
	}

	public InvoiceSummary computeTotalFare(Ride[] ride) {
		double totalfare = 0;
		double averageFare = 0;
		for(Ride rides: ride) {
			totalfare += this.computeFare(rides.distance, rides.time);	
		}
		averageFare = totalfare/ride.length;
		return new InvoiceSummary(ride.length, totalfare, averageFare);
	}
	
}
