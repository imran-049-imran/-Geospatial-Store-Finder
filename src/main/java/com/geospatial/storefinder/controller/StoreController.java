package com.geospatial.storefinder.controller;

import com.geospatial.storefinder.model.Store;
import com.geospatial.storefinder.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@CrossOrigin(origins = "*")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/nearby")
    public List<Store> getNearbyStores(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "5") double radius) {

        return storeService.findNearbyStores(lat, lon, radius);
    }
}
