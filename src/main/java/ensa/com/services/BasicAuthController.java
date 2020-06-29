package ensa.com.services;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ensa.com.entity.Authentification;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {
	@GetMapping(path = "/basicauth")
    public Authentification basicauth() {
        return new Authentification("You are authenticated");
    }
}
