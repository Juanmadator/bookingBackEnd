//package com.booking.base.services;
//
//import com.booking.base.persistence.model.PlaceTypeEntity;
//import com.booking.base.persistence.repositories.PlaceTypeRepository;
//import com.booking.generated.web.model.PlaceType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class PlaceTypeService {
//
//    private final PlaceTypeRepository placeTypeRepository;
//
//    @Autowired
//    public PlaceTypeService(PlaceTypeRepository placeTypeRepository) {
//        this.placeTypeRepository = placeTypeRepository;
//    }
//
//    @Transactional
//    public PlaceType insertPlaceType(PlaceType placeType) {
//        String label = placeType.getLabel();
//        boolean duplicate = placeTypeRepository.existsByLabel(label);
//        if (!duplicate) {
//            PlaceTypeEntity entity = convertFromWeb(placeType);
//            entity = placeTypeRepository.save(entity);
//            placeType.setId(entity.getId());
//            return placeType;
//        }
//        throw new IllegalStateException("Cannot save a PlaceType with a duplicate label " + label);
//    }
//
//    private static PlaceTypeEntity convertFromWeb(PlaceType webModel) {
//        PlaceTypeEntity entity = new PlaceTypeEntity();
//        entity.setLabel(webModel.getLabel());
//        return entity;
//    }
//}
