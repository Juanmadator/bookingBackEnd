//    package com.booking.base.services;
//
//    import com.booking.base.persistence.model.Building;
//    import com.booking.base.persistence.model.DayOfWeek;
//    import com.booking.base.persistence.repositories.BuildingDao;
//    import com.booking.base.persistence.repositories.DayOfWeekDao;
//    import org.springframework.stereotype.Service;
//
//    @Service
//    public class DayOfWeekService {
//    private final DayOfWeekDao dayOfWeekDao;
//    private final BuildingDao buildingDao;
//
//        public DayOfWeekService(DayOfWeekDao dayOfWeekDao, BuildingDao buildingDao) {
//            this.dayOfWeekDao = dayOfWeekDao;
//            this.buildingDao = buildingDao;
//        }
//
////        @Transactional
////        public void deleteDay(Long id){
////            //if exists a dayOf week with the id we delete it
////        dayOfWeekDao.deleteDayOfWeekByBuildingId(id);
////
////        }
//
//
//        public DayOfWeek createDay(DayOfWeek dayOfWeek,Long id){
//            Building building =buildingDao.findById(id).orElse(null);
//            if(building!=null){
//                //add the building to the dayOfWeek
//                dayOfWeek.setBuilding(building);
//                return dayOfWeekDao.save(dayOfWeek);
//
//            }
//            return dayOfWeek;
//        }
//
//
//    }
