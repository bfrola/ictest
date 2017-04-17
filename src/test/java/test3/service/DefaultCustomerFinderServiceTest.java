package test3.service;

import org.junit.Test;
import test3.client.DefaultCustomerClient;
import test3.model.Coordinates;
import test3.model.Customer;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Basic tests for DefaultCustomerFinderService. More advanced tests could be added
 * using tools such as EasyMock to mock the client level and test different scenarios.
 */
public class DefaultCustomerFinderServiceTest {

    private static final Coordinates DUBLIN_COORDINATES = Coordinates.builder().latitude(53.3393).longitude(-6.2576841).build();
    private static final double SEARCH_RADIUS = 100;

    private DefaultCustomerFinderService finderService = new DefaultCustomerFinderService();

    @Test
    public void testFindWithinRadiusPresents() throws Exception {
        List<Customer> searchResult = finderService.findWithinRadius(DUBLIN_COORDINATES, SEARCH_RADIUS);
        assertEquals(16, searchResult.size());

        assertEquals(Customer.builder().userId(12).name("Christina McArdle")
                        .coordinates(Coordinates.builder().latitude(52.986375).longitude(-6.043701).build()).build(),
                searchResult.get(0));
        assertEquals(Customer.builder().userId(31).name("Alan Behan")
                        .coordinates(Coordinates.builder().latitude(53.1489345).longitude(-6.8422408).build()).build(),
                searchResult.get(7));
        assertEquals(Customer.builder().userId(23).name("Eoin Gallagher")
                        .coordinates(Coordinates.builder().latitude(54.080556).longitude(-6.361944).build()).build(),
                searchResult.get(15));
    }

    @Test
    public void testFindWithinRadiusAbsents() throws Exception {
        List<Customer> searchResult = finderService.findWithinRadius(DUBLIN_COORDINATES, SEARCH_RADIUS);
        assertEquals(16, searchResult.size());

        // Make sure that some customer we know are farther away than 100 Km are not there
        assertFalse(searchResult.stream().filter(customer -> customer.getUserId() == 1).findFirst().isPresent());
        assertFalse(searchResult.stream().filter(customer -> customer.getUserId() == 10).findFirst().isPresent());
        assertFalse(searchResult.stream().filter(customer -> customer.getUserId() == 25).findFirst().isPresent());
    }
}