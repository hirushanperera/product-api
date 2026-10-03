package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/status")

    public String hello(){
        return "SpringBoots is working on Apache Tomcat server!";
    }

}
