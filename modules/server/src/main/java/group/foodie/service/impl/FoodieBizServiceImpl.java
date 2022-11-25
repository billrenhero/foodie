package group.foodie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import group.foodie.dao.entity.Foodie;
import group.foodie.dao.service.FoodieService;
import group.foodie.entity.request.FoodTruck;
import group.foodie.enums.FacilityTypeEnum;
import group.foodie.enums.StatusEnum;
import group.foodie.service.FoodieBizService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

/**
 * foodie service
 *
 * @author renmingyuan
 * @date 2022/11/25
 */
@Slf4j
@Service
public class FoodieBizServiceImpl implements FoodieBizService {

    @Resource
    private FoodieService foodieService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveFoodieData(List<String> data) {
        List<String> locationIds = new ArrayList<>();
        List<Foodie> foodieList = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] line = data.get(i).split(",");
            locationIds.add(line[0]);
            String zipCode = line.length >= 29 ? line[28] : "";
            int neighborhood = line.length >= 30 ? Integer.parseInt(line[29]) : 0;
            foodieList.add(
                    Foodie.builder()
                            .locationId(line[0])
                            .applicant(line[1].replaceAll("\"", ""))
                            .facilityType(FacilityTypeEnum.getNums(line[2]))
                            .locationDescription(line[4])
                            .address(line[5])
                            .status(StatusEnum.getNums(line[10]))
                            .foodItems(line[11])
                            .latitude(line[14])
                            .longitude(line[15])
                            .zipCode(zipCode)
                            .neighborhoods(neighborhood)
                            .build()
            );
        }
        LambdaQueryWrapper<Foodie> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Foodie::getId, Foodie::getLocationId);
        queryWrapper.in(Foodie::getLocationId, locationIds);
        List<Foodie> updateFoodieList = foodieService.list(queryWrapper);
        Map<String, Integer> updateIdMap = new HashMap<>();
        updateFoodieList.forEach(f -> updateIdMap.put(f.getLocationId(), f.getId()));
        List<Foodie> updateList = new ArrayList<>();
        List<Foodie> insertList = new ArrayList<>();
        for (Foodie foodie : foodieList) {
            if (updateIdMap.containsKey(foodie.getLocationId())) {
                foodie.setId(updateIdMap.get(foodie.getLocationId()));
                updateList.add(foodie);
            } else {
                foodie.setCreatedDate(LocalDateTime.now());
                insertList.add(foodie);
            }
        }
        saveFoodies(insertList);
        updateFoodies(updateList);
        log.info("insert List: {}", insertList);
        log.info("update List: {}", updateList);
    }

    @Override
    public List<Foodie> getSpecifiedApprovedFoodTrucks(FoodTruck foodTruck) {
        LambdaQueryWrapper<Foodie> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(foodTruck.getApplicant()), Foodie::getApplicant, foodTruck.getApplicant());
        queryWrapper.eq(StringUtils.isNotBlank(foodTruck.getFacilityType()), Foodie::getFacilityType, FacilityTypeEnum.getNums(foodTruck.getFacilityType()));
        queryWrapper.eq(StringUtils.isNotBlank(foodTruck.getStatus()), Foodie::getStatus, StatusEnum.getNums(foodTruck.getStatus()));
        return foodieService.list(queryWrapper);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveFoodies(List<Foodie> insertList) {
        foodieService.saveBatch(insertList);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateFoodies(List<Foodie> updateList) {
        foodieService.updateBatchById(updateList);
    }
}
