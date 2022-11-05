package net.ghaines.httpinterfaces.controller;

import net.ghaines.httpinterfaces.client.BreweryClient;
import net.ghaines.httpinterfaces.model.Brewery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BreweryController {

    final BreweryClient breweryClient;
    public BreweryController(BreweryClient breweryClient) {
        this.breweryClient = breweryClient;
    }

    @GetMapping("/brewery")
    public Object byName(@RequestParam(value = "name", required = false) String name) {
        List<Brewery> brewery = breweryClient.byName(name);
        if (brewery.isEmpty()) {
            return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Could not find brewery");
        }
        return ResponseEntity.status(HttpStatus.OK).body(brewery);
    }

}
