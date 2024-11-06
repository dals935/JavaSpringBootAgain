package com.example.jsbdev.product.headers;

import com.example.jsbdev.product.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false, defaultValue = "PH") String region) {

        if(region.equals("PH")) return "KUPAL KA BA?";
        if(region.equals("CN")) return "CHING CHONG BING BONG?";

        return "Are you an Alien?";

    }

    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("Test1");
        product.setDescription("hehehe");

        return ResponseEntity.ok(product);
    }
}
