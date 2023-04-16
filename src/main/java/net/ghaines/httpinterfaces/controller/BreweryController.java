package net.ghaines.httpinterfaces.controller;

import lombok.RequiredArgsConstructor;
import net.ghaines.httpinterfaces.client.BreweryClient;
import net.ghaines.httpinterfaces.exception.BreweryException;
import net.ghaines.httpinterfaces.model.Brewery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BreweryController {

    private final BreweryClient breweryClient;

    @GetMapping("/brewery/{name}")
    public ResponseEntity<List<Brewery>> byName(@PathVariable(value = "name") String name)
            throws BreweryException {
        List<Brewery> brewery = breweryClient.byName(name);
        if (brewery.isEmpty()) {
            throw new BreweryException("Could not find brewery");
        }
        return ResponseEntity.ok(brewery);
    }

}
