package test3.client;

import org.junit.Test;
import test3.model.Coordinates;
import test3.model.Customer;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefaultCustomerClientTest {

    private DefaultCustomerClient customerClient = new DefaultCustomerClient();

    @Test
    public void testFetchCustomersWithInputFile() throws Exception {
        Optional<List<Customer>> listOpt = customerClient.fetchCustomers();
        assertTrue(listOpt.isPresent());
        assertEquals(32, listOpt.get().size());

        assertEquals(Customer.builder().userId(12).name("Christina McArdle")
                .coordinates(Coordinates.builder().latitude(52.986375).longitude(-6.043701).build()).build(),
                listOpt.get().get(0));
        assertEquals(Customer.builder().userId(31).name("Alan Behan")
                .coordinates(Coordinates.builder().latitude(53.1489345).longitude(-6.8422408).build()).build(),
                listOpt.get().get(15));
        assertEquals(Customer.builder().userId(25).name("David Behan")
                .coordinates(Coordinates.builder().latitude(52.833502).longitude(-8.522366).build()).build(),
                listOpt.get().get(31));
    }
}