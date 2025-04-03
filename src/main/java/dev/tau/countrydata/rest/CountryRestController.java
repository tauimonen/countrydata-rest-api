package dev.tau.countrydata.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CountryRestController {

    @GetMapping("/country")
    public String sayHello() {
        return "Hello";
    }
}
