package net.ghaines.httpinterfaces.controller;

import net.ghaines.httpinterfaces.client.BreweryClient;
import net.ghaines.httpinterfaces.exception.BreweryException;
import net.ghaines.httpinterfaces.model.Brewery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BreweryControllerTest {

    @InjectMocks
    BreweryController breweryController;

    @Mock
    BreweryClient breweryClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Brewery triptych = new Brewery("1", "Triptych Brewing", "1703 Woodfield Dr",
                "Savoy", "IL", "http://www.triptychbrewing.com");
        when(breweryClient.byName("triptych")).thenReturn(List.of(triptych));
        when(breweryClient.byName("triptychz")).thenReturn(new ArrayList<>());
    }

    @Test
    void testByName() {
        ResponseEntity<List<Brewery>> resp = breweryController.byName("triptych");
        assertEquals("Savoy", resp.getBody().get(0).city());
    }

    @Test
    void testException() {
        assertThrows(BreweryException.class, () -> breweryController.byName("triptychz"));
    }

}