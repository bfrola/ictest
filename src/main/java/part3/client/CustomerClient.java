package part3.client;

import part3.model.Customer;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface CustomerClient {
    public Optional<List<Customer>> fetchCustomers();
}
