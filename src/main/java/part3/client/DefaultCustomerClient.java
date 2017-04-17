package part3.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import part3.model.Customer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Json File-based implementation of CustomerClient.
 */
public class DefaultCustomerClient implements CustomerClient {
    private ObjectMapper mapper = new ObjectMapper();
    private static final String INPUT_FILE = "src/main/resources/gistfile1.json";
    private File inputFile;

    public DefaultCustomerClient() {
        inputFile = new File(INPUT_FILE);
    }

    public Optional<List<Customer>> fetchCustomers() {
        try {
            return Optional.of((List<Customer>) mapper.readValue(inputFile, new TypeReference<List<Customer>>() {}));
        } catch (IOException e) {
            System.out.println("Error while parsing Json file ' " + INPUT_FILE + "'");
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
