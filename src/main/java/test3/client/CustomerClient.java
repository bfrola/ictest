package test3.client;

import test3.model.Customer;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface CustomerClient {
    public Optional<List<Customer>> fetchCustomers();
}
