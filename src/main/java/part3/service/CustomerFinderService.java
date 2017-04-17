package part3.service;

import part3.model.Coordinates;
import part3.model.Customer;

import java.util.List;

/**
 *
 */
interface CustomerFinderService {
    List<Customer> findWithinRadius(Coordinates coordinates, double radius);
}
