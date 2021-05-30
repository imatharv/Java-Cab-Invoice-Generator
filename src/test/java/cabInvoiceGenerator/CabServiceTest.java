package cabInvoiceGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CabServiceTest {
	@Test
	public void testComputeFare_ShouldReturnTotalFare() {
		
		CabService object = new CabService();
		
		double distance = 20;
		int time = 30;
		double totalFare = object.computeFare(distance,time);
		assertEquals(230, totalFare, 0.0);
	}
	
	@Test
	public void testComputeFare_ShouldReturnMinFare() {
		
		CabService object = new CabService();
		
		double distance = 1;
		int time = 5;
		double totalFare = object.computeFare(distance,time);
		assertEquals(20, totalFare, 0.0);
	}
	
	@Test
	public void testComputeFare_ShouldReturnZeroFare() {
		
		CabService object = new CabService();
		
		double distance = 0.0;
		int time = 0;
		double totalFare = object.computeFare(distance,time);
		assertEquals(0, totalFare, 0.0);
	}
}
