package part3.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Deserialize an object of Customer from Json in form:
 * {
 *   "latitude": "52.986375",
 *   "user_id": 12,
 *   "name": "Christina McArdle",
 *   "longitude": "-6.043701"
 * }
 */
public class DefaultCustomerDeserializer extends JsonDeserializer<Customer> {
    @Override
    public Customer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return Customer.builder()
                .userId(node.get("user_id").asInt())
                .name(node.get("name").asText())
                .coordinates(Coordinates.builder()
                                .longitude(node.get("longitude").asDouble())
                                .latitude(node.get("latitude").asDouble()).build()).build();
    }
}
