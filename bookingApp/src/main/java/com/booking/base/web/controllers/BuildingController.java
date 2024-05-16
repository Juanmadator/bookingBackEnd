package com.booking.base.web.controllers;

import com.booking.base.services.BuildingCreationException;
import com.booking.base.services.BuildingNotFoundException;
import com.booking.base.services.BuildingService;
import com.booking.generated.web.controllers.BuildingsApi;
import com.booking.generated.web.model.Building;
import com.booking.generated.web.model.BuildingsGet200Response;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/buildingsApi")
public class BuildingController implements BuildingsApi {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @Override
    public ResponseEntity<Building> addBuilding(Building building) throws BuildingCreationException {

        return ResponseEntity.ok(buildingService.insertBuilding(building));
    }

    @Override
    public ResponseEntity<Building> getBuilding(BigDecimal id) throws BuildingNotFoundException {

        if (buildingService.getBuilding(id) != null) {
            return ResponseEntity.ok(buildingService.getBuilding(id));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Building> updateBuilding(BigDecimal id, Building building) throws BuildingCreationException {
        Building updatedBuilding = buildingService.updateBuilding(id, building);
        return ResponseEntity.ok(updatedBuilding);
    }


    @Override
    public ResponseEntity<BuildingsGet200Response> buildingsGet(Integer page, Integer pageSize) {
        BuildingsGet200Response buildings = buildingService.getAllBuildingsWithPagination(page, pageSize);
        return ResponseEntity.ok(buildings);
    }
}
