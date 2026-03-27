package com.geospatial.storefinder.service;

import com.geospatial.storefinder.model.Store;
import com.geospatial.storefinder.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    // Haversine formula
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth radius (km)

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    public List<Store> findNearbyStores(double userLat, double userLon, double radiusKm) {
        List<Store> stores = storeRepository.findAll();

        return stores.stream()
                .filter(store -> calculateDistance(userLat, userLon,
                        store.getLatitude(), store.getLongitude()) <= radiusKm)
                .collect(Collectors.toList());
    }
}
