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
	@Test
	public void given_NormalChoice_shouldReturnTotalFare() {
		String choice = "Normal";
		double distance = 22.0;
		int minute = 10;
		double fare = object.computeFare(choice,distance, minute);
		assertEquals(230.0, fare, 0.0);
	}
	
	@Test
	public void given_PremiumChoice_shouldReturnTotalFareForGivenChoice() {
		String choice = "Premium";
		double distance = 11.0;
		int minute = 7;
		double fare = object.computeFare(choice,distance, minute);
		assertEquals(179.0, fare, 0.0);
	}
	
	@Test
	public void givenUserId_shouldReturnInvoiceSummary() throws InvalidInputException {
		String user = "UB01";
		InvoiceRecords invoicerecords = object.findInvoice(user);
		InvoiceRecords expected = new InvoiceRecords("UB01",3,363,121);
		assertEquals(expected, invoicerecords);	
	}
	
	@Test
	public void givenUserId_shouldreturnInvoiceSummary() throws InvalidInputException {
		String user = "UB03";
		InvoiceRecords invoicerecords = object.findInvoice(user);
		InvoiceRecords expected = new InvoiceRecords("UB03",4,208,52);
		assertEquals(expected, invoicerecords);	
	}
	
	@Test
	public void givenUserId_shouldReturnInvalidInputException() throws InvalidInputException {
		String user = " ";
		InvoiceRecords invoicerecords = object.findInvoice(user);
		assertEquals(null, invoicerecords);	
	}
}
