
package com.CatFacts.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bilalzahid
 */
@RestController
public class restApiController {

@GetMapping("/catfact")    
public Object getCat() {
        try {
            String url = "https://catfact.ninja/fact";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonPrice = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonPrice);
            System.out.println(root);
            return root;
        } 
        catch (JsonProcessingException ex) {
            return "error in /catfact";
        }
    } 
}

