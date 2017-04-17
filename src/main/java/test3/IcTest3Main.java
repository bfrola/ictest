package test3;

import test3.model.Coordinates;
import test3.model.Customer;
import test3.client.DefaultCustomerClient;
import test3.service.DefaultCustomerFinderService;

import java.util.List;
import java.util.Optional;

public class IcTest3Main {
    /**
     * PROBLEM:
     * We have some customer records in a text file (customers.json) -- one customer per line, JSON-encoded.
     * We want to invite any customer within 100km of our Dublin office for some food and drinks on us.
     * Write a program that will read the full list of customers and output the names and user ids of matching
     * customers (within 100km), sorted by User ID (ascending).
     *
     * SOLUTION:
     * The solutions is divided in a client module that reads the data from file and a service module that
     * filter the data based on generic input.
     *
     */
    public static final Coordinates DUBLIN_COORDINATES = Coordinates.builder().latitude(53.3393).longitude(-6.2576841).build();
    public static final double SEARCH_RADIUS = 100;

    public static void main(String args[]) {
        Optional<List<Customer>> allCustomers = new DefaultCustomerClient().fetchCustomers();
        System.out.println("All customers:");
        allCustomers.get().forEach(System.out::println);

        List<Customer> searchResult = new DefaultCustomerFinderService().findWithinRadius(DUBLIN_COORDINATES, SEARCH_RADIUS);
        System.out.println("\nList of customers within " + SEARCH_RADIUS + "Km from Dublin, " + DUBLIN_COORDINATES + ":");
        searchResult.forEach(System.out::println);
    }
}
