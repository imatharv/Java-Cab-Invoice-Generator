package cabInvoiceGenerator;

public class InvoiceRecords {
	private final String userId;
	private final int numberOfRides;
	private final double totalFare;
	private final double averageFare;
	
	public InvoiceRecords(String userId, int numberOfRides, double totalFare, double averageFare) {
		this.userId = userId;
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = averageFare;
	}
	public String getUserId() {
		return userId;
	}
	public int getRides() {
		return numberOfRides;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public double getAverageFare() {
		return averageFare;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		InvoiceRecords other = (InvoiceRecords) obj;
		
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (numberOfRides != other.numberOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
