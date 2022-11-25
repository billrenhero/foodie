package group.foodie.service;

import group.foodie.dao.entity.Foodie;
import group.foodie.entity.request.FoodTruck;

import java.util.List;

/**
 * @author renmingyuan
 * @date 2022/11/25
 */
public interface FoodieBizService {

    void saveFoodieData(List<String> data);

    List<Foodie> getSpecifiedApprovedFoodTrucks(FoodTruck foodTruck);
}
