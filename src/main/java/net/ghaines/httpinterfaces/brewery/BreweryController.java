package net.ghaines.httpinterfaces.brewery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class BreweryController {

    private final BreweryClient breweryClient;

    BreweryController(BreweryClient breweryClient) {
        this.breweryClient = breweryClient;
    }

    @GetMapping("/brewery/{name}")
    ResponseEntity<List<Brewery>> byName(@PathVariable(value = "name") String name)
            throws BreweryException {
        List<Brewery> brewery = breweryClient.byName(name);
        if (brewery.isEmpty()) {
            throw new BreweryException("Could not find brewery");
        }
        return ResponseEntity.ok(brewery);
    }

}
