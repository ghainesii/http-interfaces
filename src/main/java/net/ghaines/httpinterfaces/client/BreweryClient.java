package net.ghaines.httpinterfaces.client;

import net.ghaines.httpinterfaces.model.Brewery;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface BreweryClient {

    @GetExchange("/breweries")
    List<Brewery> byName(@RequestParam(value = "by_name") String name);

}
