package test3.service;

import test3.model.Coordinates;
import test3.model.Customer;
import test3.client.CustomerClient;
import test3.client.DefaultCustomerClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Spherical-distance based implementation of CustomerFinderService.
 */
public class DefaultCustomerFinderService implements CustomerFinderService {
    private static final double EARTH_RADIUS_KM = 6371.0;
    private CustomerClient customerClient;

    public DefaultCustomerFinderService() {
        customerClient = new DefaultCustomerClient();
    }

    /**
     * @return Distance between coordinates c1 and c2. Source: https://en.wikipedia.org/wiki/Great-circle_distance
     */
    private double calcDistanceInKm(Coordinates c1, Coordinates c2) {

        double phi1 = Math.toRadians(c1.getLatitude());
        double phi2 = Math.toRadians(c2.getLatitude());
        double deltaLambda = Math.toRadians(c2.getLongitude() - c1.getLongitude());

        double centralAngle = Math.acos(Math.sin(phi1) * Math.sin(phi2) +
                Math.cos(phi1) * Math.cos(phi2) * Math.cos((deltaLambda)));
        return Math.abs(EARTH_RADIUS_KM * centralAngle);
    }

    public List<Customer> findWithinRadius(Coordinates coordinates, double radius) {
        Optional<List<Customer>> allCustomersOpt = customerClient.fetchCustomers();
        if (allCustomersOpt.isPresent()) {
            return allCustomersOpt.get().stream()
                .filter(customer -> calcDistanceInKm(coordinates, customer.getCoordinates()) <= radius)
                .collect(Collectors.toList());
        } else {
            System.out.println("Error during customer fetch.");
            return new ArrayList<>();
        }
    }
}
