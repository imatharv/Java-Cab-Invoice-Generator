package cabInvoiceGenerator;

public class InvoiceSummary {
	private final int numberOfRides;
	private final double totalFare;
	private final double averageFare;
	
	public InvoiceSummary(int numberOfRides, double totalFare, double averageFare ) {
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare= averageFare;
	}
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		InvoiceSummary other = (InvoiceSummary) obj;
		
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (numberOfRides != other.numberOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}
}
