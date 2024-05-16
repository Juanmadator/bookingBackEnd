package com.booking.base.services;


import com.booking.base.persistence.model.*;
import com.booking.base.persistence.repositories.*;
import com.booking.generated.web.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final LocationRepository locationRepository;
    private final PlaceTypeRepository placeTypeRepository;
    private final ServiceRepository serviceRepository;
    private final BookableRepository bookableRepository;
    private final DayOfWeekRepository dayOfWeekRepository;

    @Transactional
    public Building insertBuilding(Building building) throws BuildingCreationException {
        if (!buildingRepository.existsByName(building.getName())) {
            BuildingEntity buildingEntity = convertFromWeb(building);
            LocationEntity locationEntity = convertLocation(building.getLocation());
            PlaceTypeEntity placeTypeEntity = convertPlaceType(building.getPlaceType());
            LocationEntity existingLocation =
                    locationRepository.findByAddressAndLatitudeAndLongitude(locationEntity.getAddress(), locationEntity.getLatitude(), locationEntity.getLongitude());
            PlaceTypeEntity existingPlaceType =
                    placeTypeRepository.findByLabel(placeTypeEntity.getLabel());
            //if the location doesn´t exist , it will be created , instead it wont be created
            if (existingLocation == null) {
                locationEntity = locationRepository.save(locationEntity);
            } else {
                locationEntity = existingLocation;
            }
            if (existingPlaceType == null) {
                placeTypeEntity = placeTypeRepository.save(placeTypeEntity);
            } else {
                placeTypeEntity = existingPlaceType;
            }
            buildingEntity.setLocation(locationEntity);
            buildingEntity.setPlaceType(placeTypeEntity);
            buildingRepository.save(buildingEntity);
            //check if services exists
            List<ServiceEntity> servicios = getServiceEntities(building, buildingEntity);
            buildingEntity.setServices(servicios);
            buildingEntity = buildingRepository.save(buildingEntity);

            List<DayOfWeekEntity> days = getDaysEntities(building, buildingEntity);
            buildingEntity.setDaysOfWeek(days);
            buildingEntity = buildingRepository.save(buildingEntity);

            List<BookableEntity> bookableEntities = getBookableEntities(building, buildingEntity);
            buildingEntity.setBookables(bookableEntities);
            buildingEntity = buildingRepository.save(buildingEntity);

            return building;
        }
        throw new BuildingCreationException("Couldn´t create the building with the same name.");

    }

    public Building getBuilding(BigDecimal id) {
        Long longId = id.longValue();
        BuildingEntity buildingEntity = buildingRepository.findById(longId).orElseThrow();
        Building building = convertToBuilding(buildingEntity);
        return building;
    }

    @Transactional
    public Building updateBuilding(BigDecimal id, Building building) {
        Long longId = id.longValue();
        BuildingEntity buildingEntity = buildingRepository.findById(longId).orElseThrow();
        BuildingEntity updatingBuilding = convertFromWeb(building);
        if (buildingEntity != null) {
            updatingBuilding.setId(longId);
            updatingBuilding.setName(building.getName());
            updatingBuilding.setDescription(building.getDescription());
            updatingBuilding.setPhoto(building.getPhoto());

            LocationEntity locationEntity = convertLocation(building.getLocation());
            LocationEntity existingLocation=locationRepository.findByAddressAndLatitudeAndLongitude(locationEntity.getAddress(),locationEntity.getLatitude(),locationEntity.getLongitude());
            if(existingLocation==null){
                locationEntity = locationRepository.save(locationEntity);
            }else{
                locationEntity=existingLocation;
            }
            updatingBuilding.setLocation(locationEntity);

            PlaceTypeEntity placeTypeEntity = convertPlaceType(building.getPlaceType());
            PlaceTypeEntity existingPlace=placeTypeRepository.findByLabel(placeTypeEntity.getLabel());
            if(existingPlace==null){
                placeTypeEntity = placeTypeRepository.save(placeTypeEntity);
            }else{
                placeTypeEntity=existingPlace;
            }
            updatingBuilding.setPlaceType(placeTypeEntity);

            // Eliminar los servicios anteriores del edificio
            List<ServiceEntity> existingServices = serviceRepository.findByBuildingId(longId);
            for (ServiceEntity service : existingServices) {
                serviceRepository.delete(service);
            }
            // Agregar los nuevos servicios
            List<ServiceEntity> serviceEntities = getServiceEntities(building, updatingBuilding);
            updatingBuilding.setServices(serviceEntities);

            // Eliminar los días de la semana anteriores del edificio
            List<DayOfWeekEntity> existingDaysOfWeek = dayOfWeekRepository.findByBuildingId(longId);
            for (DayOfWeekEntity dayOfWeek : existingDaysOfWeek) {
                dayOfWeekRepository.delete(dayOfWeek);
            }
            // Agregar los nuevos días de la semana
            List<DayOfWeekEntity> dayOfWeekEntities = getDaysEntities(building, updatingBuilding);
            updatingBuilding.setDaysOfWeek(dayOfWeekEntities);

            // Eliminar los elementos reservables anteriores del edificio
            List<BookableEntity> existingBookables = bookableRepository.findByBuildingId(longId);
            for (BookableEntity bookable : existingBookables) {
                bookableRepository.delete(bookable);
            }
            // Agregar los nuevos elementos reservables
            List<BookableEntity> bookableEntities = getBookableEntities(building, updatingBuilding);
            updatingBuilding.setBookables(bookableEntities);
            updatingBuilding = buildingRepository.save(updatingBuilding);
            return convertToBuilding(updatingBuilding);
        }
        return null;
    }


    public BuildingsGet200Response getAllBuildingsWithPagination(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<BuildingEntity> buildingEntitiesPage = buildingRepository.findAll(pageRequest);
        List<Building> buildings = new ArrayList<>();
        for (BuildingEntity entity : buildingEntitiesPage.getContent()) {
            buildings.add(convertToBuilding(entity));
        }
        PaginationSummary pagination = new PaginationSummary();
        pagination.setCurrentPage(page);
        pagination.setPageSize(size);
        pagination.setTotalCount(buildings.size());
        pagination.setTotalPages(buildingEntitiesPage.getTotalPages());

        // Crea un objeto BuildingsGet200Response y configura los datos y la paginación
        BuildingsGet200Response response = new BuildingsGet200Response();
        response.setData(buildings);
        response.setPagination(pagination);

        return response;
    }



    private List<BookableEntity> getBookableEntities(Building building, BuildingEntity buildingEntity) {
        List<BookableEntity> bookableEntities = new ArrayList<>();
        for (Bookable bookable : building.getBookables()) {
            BookableEntity existingBookable = bookableRepository.findByLabelAndBuildingId(bookable.getLabel(), buildingEntity.getId());
            if (existingBookable == null) {
                BookableEntity bookableEntity = new BookableEntity();
                bookableEntity.setLabel(bookable.getLabel());
                bookableEntity.setSlots(bookable.getSlots());
                bookableEntity.setBuilding(buildingEntity);
                bookableEntity = bookableRepository.save(bookableEntity);
                bookableEntities.add(bookableEntity);
            } else {
                existingBookable.setBuilding(buildingEntity);
                existingBookable = bookableRepository.save(existingBookable);
                bookableEntities.add(existingBookable);
            }
        }
        return bookableEntities;
    }

    private List<ServiceEntity> getServiceEntities(Building building, BuildingEntity buildingEntity) {
        List<ServiceEntity> servicios = new ArrayList<>();
        for (Service service : building.getServices()) {
            ServiceEntity existsService = serviceRepository.findByLabelAndBuildingId(service.getLabel(), buildingEntity.getId());
            if (existsService == null) {
                ServiceEntity serviceEntity = new ServiceEntity();
                serviceEntity.setLabel(service.getLabel());
                serviceEntity.setBuilding(buildingEntity);
                serviceEntity = serviceRepository.save(serviceEntity);
                servicios.add(serviceEntity);
            } else {
                existsService.setBuilding(buildingEntity);
                existsService = serviceRepository.save(existsService);
                servicios.add(existsService);
            }
        }
        return servicios;
    }

    private List<DayOfWeekEntity> getDaysEntities(Building building, BuildingEntity buildingEntity) {
        List<DayOfWeekEntity> daysEntities = new ArrayList<>();
        for (DayOfWeek dayOfWeek : building.getDaysOfWeek()) {
            DayOfWeekEntity existDayOfWeek = dayOfWeekRepository.findByDayAndOpeningTimeAndClosingTimeAndIsClosedAndBuildingId(
                    dayOfWeek.getDay(), LocalTime.parse(dayOfWeek.getOpeningTime()), LocalTime.parse(dayOfWeek.getClosingTime()), dayOfWeek.getIsClosed(), buildingEntity.getId());
            if (existDayOfWeek == null) {
                DayOfWeekEntity dayOfWeekEntity = new DayOfWeekEntity();
                dayOfWeekEntity.setDay(dayOfWeek.getDay());
                dayOfWeekEntity.setClosingTime(LocalTime.parse(dayOfWeek.getClosingTime()));
                dayOfWeekEntity.setOpeningTime(LocalTime.parse(dayOfWeek.getOpeningTime()));
                dayOfWeekEntity.setIsClosed(dayOfWeek.getIsClosed());
                dayOfWeekEntity.setBuilding(buildingEntity);
                dayOfWeekEntity = dayOfWeekRepository.save(dayOfWeekEntity);
                daysEntities.add(dayOfWeekEntity);
            } else {
                existDayOfWeek.setBuilding(buildingEntity);
                existDayOfWeek = dayOfWeekRepository.save(existDayOfWeek);
                daysEntities.add(existDayOfWeek);
            }
        }
        return daysEntities;
    }

    private Building convertToBuilding(BuildingEntity entity) {
        Building building = new Building();
        building.setName(entity.getName());
        building.setDescription(entity.getDescription());
        building.setPhoto(entity.getPhoto());
        building.setLocation(convertLocationEntity(entity.getLocation()));
        building.setPlaceType(convertPlaceTypeEntity(entity.getPlaceType()));

        if (entity.getServices() != null || !entity.getServices().isEmpty()) {
            List<Service> services = new ArrayList<>();
            for (ServiceEntity serviceEntity : entity.getServices()) {
                services.add(convertServiceEntity(serviceEntity));
            }
            building.setServices(services);
        }

        if (entity.getBookables() != null) {
            List<Bookable> bookables = new ArrayList<>();
            for (BookableEntity bookableEntity : entity.getBookables()) {
                Bookable bookable = convertBookableEntity(bookableEntity);
                bookables.add(bookable);
            }
            building.setBookables(bookables);
        }


        List<DayOfWeek> dayOfWeeks = new ArrayList<>();
        for (DayOfWeekEntity dayOfWeekEntity : entity.getDaysOfWeek()) {
            DayOfWeek dayOfWeek = convertDayOfWeekEntity(dayOfWeekEntity);
            dayOfWeeks.add(dayOfWeek);
        }
        building.setDaysOfWeek(dayOfWeeks);

        return building;
    }



    private static BuildingEntity convertFromWeb(Building webModel) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setName(webModel.getName());
        buildingEntity.setDescription(webModel.getDescription());
        buildingEntity.setPhoto(webModel.getPhoto());
        // in case that exists services in the building
        //create a list of Services with the services of the webModel
        if (webModel.getServices() != null || !webModel.getServices().isEmpty()) {
            List<ServiceEntity> serviceEntities = new ArrayList<>();
            for (Service service : webModel.getServices()) {
                ServiceEntity serviceEntity = convertService(service, buildingEntity);
                serviceEntities.add(serviceEntity);
            }
            buildingEntity.setServices(serviceEntities);
        }

        //COMIENZO BOOKABLE
        if (webModel.getBookables() != null || !webModel.getBookables().isEmpty()) {
            List<BookableEntity> bookableEntities = new ArrayList<>();
            for (Bookable bookable : webModel.getBookables()) {
                BookableEntity bookableEntity = convertBookable(bookable, buildingEntity);
                bookableEntities.add(bookableEntity);
            }
            buildingEntity.setBookables(bookableEntities);
        }
        //FIN BOOKABLE

        // there will always be several days
        //create a list of DaysOfWeek with the days of the webModel
        List<DayOfWeekEntity> dayOfWeekEntities = new ArrayList<>();
        for (DayOfWeek dayOfWeek : webModel.getDaysOfWeek()) {
            DayOfWeekEntity dayOfWeekEntity = convertDayOfWeek(dayOfWeek, buildingEntity);
            dayOfWeekEntities.add(dayOfWeekEntity);
        }
        buildingEntity.setDaysOfWeek(dayOfWeekEntities);
        return buildingEntity;
    }

    private static ServiceEntity convertService(Service service, BuildingEntity buildingEntity) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setLabel(service.getLabel());
        serviceEntity.setBuilding(buildingEntity);
        return serviceEntity;
    }

    private static BookableEntity convertBookable(Bookable bookable, BuildingEntity buildingEntity) {
        BookableEntity bookableEntity = new BookableEntity();
        bookableEntity.setLabel(bookable.getLabel());
        bookableEntity.setSlots(bookable.getSlots());
        bookableEntity.setBuilding(buildingEntity);
        return bookableEntity;
    }

    private static Bookable convertBookableEntity(BookableEntity bookableEntity) {
        Bookable bookable = new Bookable();
        bookable.setLabel(bookableEntity.getLabel());
        bookable.setSlots(bookableEntity.getSlots());
        return bookable;
    }

    private static Service convertServiceEntity(ServiceEntity entity) {
        Service service = new Service();
        service.setLabel(entity.getLabel());
        return service;
    }

    private static DayOfWeek convertDayOfWeekEntity(DayOfWeekEntity entity) {
        DayOfWeek dayOfWeek = new DayOfWeek();
        dayOfWeek.setDay(entity.getDay());
        dayOfWeek.setIsClosed(entity.getIsClosed());
        dayOfWeek.setOpeningTime(String.valueOf(entity.getOpeningTime()));
        dayOfWeek.setClosingTime(String.valueOf(entity.getClosingTime()));
        return dayOfWeek;
    }

    private static DayOfWeekEntity convertDayOfWeek(DayOfWeek dayOfWeek, BuildingEntity buildingEntity) {
        DayOfWeekEntity dayOfWeekEntity = new DayOfWeekEntity();
        dayOfWeekEntity.setDay(dayOfWeek.getDay());
        dayOfWeekEntity.setBuilding(buildingEntity);
        dayOfWeekEntity.setIsClosed(dayOfWeek.getIsClosed());
        dayOfWeekEntity.setOpeningTime(LocalTime.parse(dayOfWeek.getOpeningTime()));
        dayOfWeekEntity.setClosingTime(LocalTime.parse(dayOfWeek.getClosingTime()));
        return dayOfWeekEntity;
    }

    private static PlaceTypeEntity convertPlaceType(PlaceType placeType) {
        PlaceTypeEntity placeTypeEntity = new PlaceTypeEntity();
        placeTypeEntity.setLabel(placeType.getLabel());
        return placeTypeEntity;
    }

    private static PlaceType convertPlaceTypeEntity(PlaceTypeEntity entity) {
        PlaceType placeType = new PlaceType();
        placeType.setLabel(entity.getLabel());
        return placeType;
    }

    private static LocationEntity convertLocation(Location location) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLatitude(location.getLatitude());
        locationEntity.setLongitude(location.getLongitude());
        locationEntity.setAddress(location.getAddress());
        return locationEntity;
    }

    private static Location convertLocationEntity(LocationEntity entity) {
        Location location = new Location();
        location.setLatitude(entity.getLatitude());
        location.setLongitude(entity.getLongitude());
        location.setAddress(entity.getAddress());
        return location;
    }

}