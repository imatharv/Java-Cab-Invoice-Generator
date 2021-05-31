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
	public void testComputeFare_shouldReturnTotalFare_AverageFare_TotalRides() {	
		Ride[] rides= { new Ride(2.0,5), new Ride(0.1,1) };
	
		InvoiceSummary invoiceSummary = object.computeTotalFare(rides);
		InvoiceSummary expected = new InvoiceSummary(2, 45, 22.5);
		assertEquals(expected, invoiceSummary);	
	}
}
