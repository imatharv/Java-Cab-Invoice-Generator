package cabInvoiceGenerator;

import java.util.ArrayList;

public class CabService {
	
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int MINIMUM_FARE = 20;
	private static final int COST_PER_TIME_PR = 2;
	private static final double MINIMUM_COST_PER_KM_PR = 15;
	private static final int MINIMUM_FARE_PR = 30;
	
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
	
	public double computeFare(String choice, double distance, int minute) {
		if(choice.equalsIgnoreCase("Normal")) {
			totalfare = (distance * MINIMUM_COST_PER_KM) + (minute * COST_PER_TIME);
			return totalfare;
		} 
		else if(choice.equalsIgnoreCase("Premium")) {
			double totalfare = (distance * MINIMUM_COST_PER_KM_PR) + (minute * COST_PER_TIME_PR);
			return totalfare;
		}
		return totalfare;
	}
	
	public InvoiceRecords findInvoice(String userId) throws InvalidInputException {
		try {
			ArrayList<InvoiceRecords> records = new ArrayList<InvoiceRecords>();
			
			records.add(new InvoiceRecords("UB01",3,363,121));
			records.add(new InvoiceRecords("UB02",2,340,170));
			records.add(new InvoiceRecords("UB03",4,208,52));
			records.add(new InvoiceRecords("UB04",8,480,60));
		
			InvoiceRecords user = null;
			for (int i = 0; i < records.size(); i++) {
				if (userId.equals(records.get(i).getUserId())) {
					user = records.get(i);
					user.getRides();
					user.getTotalFare();
					user.getAverageFare();
					break;
				} 
			}
			return user;
		} 
		catch (NullPointerException e ) {
			throw new InvalidInputException("Invalid input, no record(s) found.");
		}
	}
	
}
