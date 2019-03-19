package com.elasticdemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.elasticdemo.model.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Util {

    public static List<Order> getOrdersFromJsonFile() {
        List<Order> orders = new ArrayList<Order>();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Order>> typeReference = new TypeReference<List<Order>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/orders-bulk.json");
        try {
            orders = mapper.readValue(inputStream, typeReference);

        } catch (IOException e) {
            System.out.println("Unable to save users: " + e.getMessage());
        }
        return orders;

    }

}
