package test3.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
@JsonDeserialize(using = DefaultCustomerDeserializer.class)
public class Customer {
    private Integer userId;
    private String name;
    private Coordinates coordinates;
}
