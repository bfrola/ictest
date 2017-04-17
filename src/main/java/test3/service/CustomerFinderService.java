package test3.service;

import test3.model.Coordinates;
import test3.model.Customer;

import java.util.List;

/**
 *
 */
interface CustomerFinderService {
    List<Customer> findWithinRadius(Coordinates coordinates, double radius);
}
