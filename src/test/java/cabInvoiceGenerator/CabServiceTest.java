package cabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CabServiceTest {
	
	CabService object = new CabService();
	
	@Test
	public void testComputeFare_ShouldReturnTotalFare() {
		double distance = 20;
		int time = 30;
		double totalFare = object.computeFare(distance,time);
		assertEquals(230, totalFare, 0.0);
	}
	@Test
	public void testComputeFare_ShouldReturnMinFare() {
		double distance = 1;
		int time = 5;
		double totalFare = object.computeFare(distance,time);
		assertEquals(20, totalFare, 0.0);
	}
	@Test
	public void testComputeFare_ShouldReturnZeroFare() {
		double distance = 0.0;
		int time = 0;
		double totalFare = object.computeFare(distance,time);
		assertEquals(0, totalFare, 0.0);
	}
	@Test
	public void testComputeFare_ShouldReturnTotalFareForMultipleRides() {	
		double distance = 2.5;
		int time = 10;
		int rides = 3;
		double totalFare = object.computeFare(distance,time);
		double totalFareForMultipleRides = object.computeFareForMultipleRide(totalFare,rides);
		assertEquals(105, totalFareForMultipleRides, 0.0);
	}
}
