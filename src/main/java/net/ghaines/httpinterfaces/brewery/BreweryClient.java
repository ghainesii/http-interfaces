package net.ghaines.httpinterfaces.brewery;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

interface BreweryClient {

    @GetExchange("/breweries")
    List<Brewery> byName(@RequestParam(value = "by_name") String name);

}
